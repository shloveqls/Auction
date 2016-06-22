package com.freedom.auction.top;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.freedom.auction.model.item.Catalog;
import com.freedom.auction.model.item.Item;

import java.util.List;
import java.util.Map;

/**
 * A {@link FragmentStatePagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class CatalogViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Catalog> mCatalogList = null;

    private Map<String, List<Item>> mItemMap = null;

    public CatalogViewPagerAdapter(FragmentManager fm, List<Catalog> catalogList, Map<String, List<Item>> itemMap) {
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
        return ItemFragment.newInstance(2, mItemMap.get(mCatalogList.get(position).getCatalogId()));
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
