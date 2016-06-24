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
        itemRes.setItemList(createItemListDummy());
        return itemRes;
    }

    public List<Item> getItemList() {
        return mItemList;
    }

    public void setItemList(List<Item> itemList) {
        this.mItemList = itemList;
    }

    //Delete
    private static List<Item> createItemListDummy() {

        int count = 30;

        List<Item> itemList = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i * 10000));
            item.setCatalogId("1");
            item.setName("Item" + i * 10000);
            item.setPrice("¥" + i * 10000 * 100);
            itemList.add(item);
        }

        return itemList;
    }

}
