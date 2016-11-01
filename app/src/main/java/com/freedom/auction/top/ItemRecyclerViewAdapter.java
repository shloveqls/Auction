package com.freedom.auction.top;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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

    private List<Item> mItemList;
    private final OnListFragmentInteractionListener mListener;

    public ItemRecyclerViewAdapter(List<Item> itemList, OnListFragmentInteractionListener listener) {
        setItemList(itemList);
        mListener = listener;
    }

    public void setItemList(List<Item> itemList) {
        this.mItemList = itemList;
    }

    public void replaceData(List<Item> itemList, boolean isSwipe) {
        if (isSwipe) {
            setItemList(itemList);
        } else {
            mItemList.addAll(itemList);
        }
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_top_item_detail, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mItemList.get(position);
        String imageIcon = mItemList.get(position).getItemDetail().getImageIcon();
        if (!TextUtils.isEmpty(imageIcon)) {
            holder.mImageView.setImageResource(Integer.valueOf(imageIcon));
        }
        holder.mNameView.setText(mItemList.get(position).getItemDetail().getName());
        holder.mPriceView.setText(mItemList.get(position).getItemDetail().getPrice());

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
        public final ImageView mImageView;
        public final TextView mNameView;
        public final TextView mPriceView;
        public Item mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.iv_item_icon);
            mNameView = (TextView) view.findViewById(R.id.tv_item_name);
            mPriceView = (TextView) view.findViewById(R.id.tv_item_price);
        }
    }
}
