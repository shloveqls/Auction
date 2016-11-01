package com.freedom.auction.top;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.freedom.auction.R;
import com.freedom.auction.model.item.Catalog;
import com.freedom.auction.model.item.Item;
import com.freedom.auction.util.ActivityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopFragment extends Fragment implements TopContract.View, ItemFragment.OnListFragmentInteractionListener {

    private static final int DEFAULT_SELECTED_TAB_INDEX = 1;

    private TopContract.Presenter mTopPresenter;

    private CatalogViewPagerAdapter mCatalogsPagerAdapter;

    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    private ProgressDialog mProgressDialog;

    public static TopFragment newInstance() {
        return new TopFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_top, container, false);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mCatalogsPagerAdapter = new CatalogViewPagerAdapter(getChildFragmentManager(),
                new ArrayList<Catalog>(), new HashMap<String, List<Item>>());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) root.findViewById(R.id.viewpager_top);
        mViewPager.setAdapter(mCatalogsPagerAdapter);

        mTabLayout = (TabLayout) root.findViewById(R.id.tab_layout_top);
        mTabLayout.setupWithViewPager(mViewPager);

        createProgressDialog();

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mTopPresenter.start();
    }

    @Override
    public void setPresenter(TopContract.Presenter presenter) {
        mTopPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (mProgressDialog != null) {
            if (active) {
                mProgressDialog.show();
            } else {
                mProgressDialog.dismiss();
            }
        }
    }

    @Override
    public void showCatalogs(List<Catalog> catalogList, Map<String, List<Item>> itemMap) {
        mCatalogsPagerAdapter.replaceData(catalogList, itemMap);
        selectDefaultTab();
    }

    @Override
    public void refreshItems(List<Item> itemList, ItemFragment itemFragment, boolean isSwipe) {
        itemFragment.refreshItems(itemList, isSwipe);
    }

    @Override
    public void showItemDetail(String itemId) {

    }

    @Override
    public void onListFragmentInteraction(Item item) {
        showItemDetail(item.getItemId());
    }

    public void getItemsByPrimaryCatalogId(String primaryCatalogId, int start, int end,
                                    ItemFragment itemFragment, boolean isSwipe) {
        mTopPresenter.getItemsByPrimaryCatalogId(primaryCatalogId, start, end, itemFragment, isSwipe);
    }

    private void createProgressDialog() {
        mProgressDialog = new ProgressDialog(getContext(), R.style.AppTheme_Dark_Dialog);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(ActivityUtils.getResource(getContext(), R.string.dialog_loading, String.class));
    }

    private void selectDefaultTab() {
        if (mTabLayout.getTabCount() > 2) {
            TabLayout.Tab tab = mTabLayout.getTabAt(DEFAULT_SELECTED_TAB_INDEX);
            if (tab != null) {
                tab.select();
            }
        }
    }
}
