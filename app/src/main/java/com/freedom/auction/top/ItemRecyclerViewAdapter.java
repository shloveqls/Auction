package com.freedom.auction.top;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freedom.auction.R;
import com.freedom.auction.model.item.Item;
import com.freedom.auction.top.ItemFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Item} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {

    private final List<Item> mItemList;
    private final OnListFragmentInteractionListener mListener;

    public ItemRecyclerViewAdapter(List<Item> itemList, OnListFragmentInteractionListener listener) {
        mItemList = itemList;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_top_item_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mItemList.get(position);
        holder.mIdView.setText(mItemList.get(position).getItemId());
        holder.mNameView.setText(mItemList.get(position).getName());
        holder.mPriceView.setText(mItemList.get(position).getPrice());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mNameView;
        public final TextView mPriceView;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_id);
            mNameView = (TextView) view.findViewById(R.id.item_name);
            mPriceView = (TextView) view.findViewById(R.id.item_price);
        }
    }
}
