package com.freedom.auction.model.item;

import com.freedom.auction.R;
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

        int count = 36;

        List<Item> itemList = new ArrayList<>();
        for (int i = count * 15 + 1; i <= count * 16; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i * 10000));
            item.setCatalogId("1");
            item.setName("Item" + i * 10000);
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setPrice("¥" + i * 10000 * 100);
            if (i % 2 == 0) {
                itemDetail.setImageIcon(String.valueOf(R.drawable.ic_item_sample_1));
            } else if (i % 3 == 0) {
                itemDetail.setImageIcon(String.valueOf(R.drawable.ic_item_sample_2));
            } else {
                itemDetail.setImageIcon(String.valueOf(R.drawable.ic_item_sample_3));
            }
            item.setItemDetail(itemDetail);
            itemList.add(item);
        }

        return itemList;
    }

}
