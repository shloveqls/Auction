package com.freedom.auction.top;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freedom.auction.R;
import com.freedom.auction.model.item.Item;

import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ItemFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 2;

    private String mCatalogId;
    private List<Item> mItemList;

    private SwipeRefreshLayout mSwipeRefreshLayout;

    private RecyclerView mRecyclerView;

    private ItemRecyclerViewAdapter mItemRecyclerViewAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    public static ItemFragment newInstance(int columnCount, String catalogId, List<Item> itemList) {
        ItemFragment fragment = new ItemFragment();
        fragment.setCatalogId(catalogId);
        fragment.setItemList(itemList);

        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_top_detail, container, false);

        Context context = root.getContext();
        final TopFragment topFragment = (TopFragment) getParentFragment();

        mSwipeRefreshLayout = (SwipeRefreshLayout) root;
        // Setup refresh listener which triggers new data loading
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                topFragment.getItemsByCatalogId(mCatalogId, ItemFragment.this);
            }
        });
        // Configure the refreshing colors
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        mRecyclerView = (RecyclerView) root.findViewById(R.id.recycler_view_top);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        if (mColumnCount <= 1) {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            GridLayoutManager gridLayoutManager = new GridLayoutManager(context, mColumnCount);
            mRecyclerView.setLayoutManager(gridLayoutManager);
        }
        mItemRecyclerViewAdapter = new ItemRecyclerViewAdapter(mItemList, topFragment);
        mRecyclerView.setAdapter(mItemRecyclerViewAdapter);

        return root;
    }

    public void refreshItems(List<Item> itemList) {
        mItemRecyclerViewAdapter.replaceData(itemList);
        // Call setRefreshing(false) to signal refresh has finished
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public void setCatalogId(String catalogId) {
        this.mCatalogId = catalogId;
    }

    public void setItemList(List<Item> itemList) {
        this.mItemList = itemList;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Item item);
    }
}
