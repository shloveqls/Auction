package com.freedom.auction.model.item;

import com.freedom.auction.model.Res;

import java.util.ArrayList;
import java.util.List;

public class ItemRes extends Res {

    private List<Item> mItemList = null;

    public static ItemRes parse(String response) {
        // TODO
        ItemRes itemRes = new ItemRes();
        itemRes.setResult(true);
        itemRes.setItemList(new ArrayList<Item>());
        return itemRes;
    }

    public List<Item> getItemList() {
        return mItemList;
    }

    public void setItemList(List<Item> itemList) {
        this.mItemList = itemList;
    }

}
