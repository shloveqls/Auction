package com.freedom.auction.top;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.freedom.auction.R;
import com.freedom.auction.model.item.Catalog;
import com.freedom.auction.model.item.Item;
import com.freedom.auction.util.ActivityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopFragment extends Fragment implements TopContract.View {

    private TopContract.Presenter mTopPresenter;

    private CatalogsPagerAdapter mCatalogsPagerAdapter;

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
        mCatalogsPagerAdapter = new CatalogsPagerAdapter(getChildFragmentManager(),
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
    }

    private void createProgressDialog() {
        mProgressDialog = new ProgressDialog(getContext(), R.style.AppTheme_Dark_Dialog);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(ActivityUtils.getResource(getContext(), R.string.dialog_loading, String.class));
    }

    /**
     * A {@link FragmentStatePagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    private class CatalogsPagerAdapter extends FragmentStatePagerAdapter {

        private List<Catalog> mCatalogList = null;

        private Map<String, List<Item>> mItemMap = null;

        public CatalogsPagerAdapter(FragmentManager fm, List<Catalog> catalogList, Map<String, List<Item>> itemMap) {
            super(fm);
            setCatalogList(catalogList);
            setItemMap(itemMap);
        }

        public void setCatalogList(List<Catalog> catalogList) {
            this.mCatalogList = catalogList;
        }

        public void setItemMap(Map<String, List<Item>> itemMap) {
            this.mItemMap = itemMap;
        }

        public void replaceData(List<Catalog> catalogList, Map<String, List<Item>> itemMap) {
            setCatalogList(catalogList);
            setItemMap(itemMap);
            notifyDataSetChanged();
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(mItemMap.get(mCatalogList.get(position).getCatalogId()));
        }

        @Override
        public int getCount() {
            return mCatalogList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mCatalogList.get(position).getName();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private List<Item> mItemList;

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(List<Item> itemList) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_top_detail, container, false);
//            TextView textView = (TextView) root.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getString(ARG_SECTION_NUMBER)));
            return root;
        }
    }
}
