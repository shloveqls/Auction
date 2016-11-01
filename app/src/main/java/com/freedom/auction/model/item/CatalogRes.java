package com.freedom.auction.model.item;

import com.freedom.auction.R;
import com.freedom.auction.model.Res;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogRes extends Res {

    private List<Catalog> mCatalogList = null;

    private Map<String, List<Item>> mItemMap = null;

    public static CatalogRes parse(String response) {
        // TODO
        CatalogRes catalogRes = new CatalogRes();
        catalogRes.setResult(true);
        catalogRes.setCatalogList(createCatalogListDummy());
        catalogRes.setItemMap(createItemMapDummy());
        return catalogRes;
    }

    public List<Catalog> getCatalogList() {
        return mCatalogList;
    }

    public void setCatalogList(List<Catalog> catalogList) {
        this.mCatalogList = catalogList;
    }

    public Map<String, List<Item>> getItemMap() {
        return mItemMap;
    }

    public void setItemMap(Map<String, List<Item>> itemMap) {
        this.mItemMap = itemMap;
    }

    // Delete
    private static List<Catalog> createCatalogListDummy() {

        List<Catalog> catalogs = new ArrayList<>();

        Catalog catalog1 = new Catalog();
        catalog1.setPrimaryCatalogId("2");
        catalog1.setName("メンズ");
        catalog1.setDisplayOrder("2");
        catalogs.add(catalog1);

        Catalog catalog2 = new Catalog();
        catalog2.setPrimaryCatalogId("1");
        catalog2.setName("すべて");
        catalog2.setDisplayOrder("1");
        catalogs.add(catalog2);

        Catalog catalog3 = new Catalog();
        catalog3.setPrimaryCatalogId("3");
        catalog3.setName("レディース");
        catalog3.setDisplayOrder("3");
        catalogs.add(catalog3);

        Catalog catalog4 = new Catalog();
        catalog4.setPrimaryCatalogId("4");
        catalog4.setName("ベビー・キッズ");
        catalog4.setDisplayOrder("4");
        catalogs.add(catalog4);

        Catalog catalog5 = new Catalog();
        catalog5.setPrimaryCatalogId("5");
        catalog5.setName("インテリア・雑貨");
        catalog5.setDisplayOrder("5");
        catalogs.add(catalog5);

        Catalog catalog6 = new Catalog();
        catalog6.setPrimaryCatalogId("6");
        catalog6.setName("コスメ・美容");
        catalog6.setDisplayOrder("6");
        catalogs.add(catalog6);

        Catalog catalog7 = new Catalog();
        catalog7.setPrimaryCatalogId("7");
        catalog7.setName("ハンドメイド");
        catalog7.setDisplayOrder("7");
        catalogs.add(catalog7);

        Catalog catalog8 = new Catalog();
        catalog8.setPrimaryCatalogId("8");
        catalog8.setName("チケット");
        catalog8.setDisplayOrder("8");
        catalogs.add(catalog8);

        Catalog catalog9 = new Catalog();
        catalog9.setPrimaryCatalogId("9");
        catalog9.setName("その他");
        catalog9.setDisplayOrder("9");
        catalogs.add(catalog9);

        Catalog catalog10 = new Catalog();
        catalog10.setPrimaryCatalogId("10");
        catalog10.setName("自動車・オートバイ");
        catalog10.setDisplayOrder("10");
        catalogs.add(catalog10);

        Catalog catalog11 = new Catalog();
        catalog11.setPrimaryCatalogId("11");
        catalog11.setName("スポーツ・レジャー");
        catalog11.setDisplayOrder("11");
        catalogs.add(catalog11);

        Catalog catalog12 = new Catalog();
        catalog12.setPrimaryCatalogId("12");
        catalog12.setName("スポーツ・レジャー");
        catalog12.setDisplayOrder("12");
        catalogs.add(catalog12);

        Catalog catalog13 = new Catalog();
        catalog13.setPrimaryCatalogId("13");
        catalog13.setName("家電・スマホ");
        catalog13.setDisplayOrder("13");
        catalogs.add(catalog13);

        Catalog catalog14 = new Catalog();
        catalog14.setPrimaryCatalogId("14");
        catalog14.setName("エンタメ");
        catalog14.setDisplayOrder("14");
        catalogs.add(catalog14);

        return catalogs;
    }

    private static Map<String, List<Item>> createItemMapDummy() {

        Map<String, List<Item>> itemListMap = new HashMap<>();

        int count = 36;

        List<Item> items1 = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("1");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items1.add(item);
        }
        itemListMap.put("1", items1);

        List<Item> items2 = new ArrayList<>();
        for (int i = count + 1; i <= count * 2; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("2");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            if (i % 2 == 0) {
                itemDetail.setImageIcon(String.valueOf(R.drawable.ic_item_sample_1));
            } else if (i % 3 == 0) {
                itemDetail.setImageIcon(String.valueOf(R.drawable.ic_item_sample_2));
            } else {
                itemDetail.setImageIcon(String.valueOf(R.drawable.ic_item_sample_3));
            }
            item.setItemDetail(itemDetail);
            items2.add(item);
        }
        itemListMap.put("2", items2);

        List<Item> items3 = new ArrayList<>();
        for (int i = count * 2 + 1; i <= count * 3; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("3");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items3.add(item);
        }
        itemListMap.put("3", items3);

        List<Item> items4 = new ArrayList<>();
        for (int i = count * 3 + 1; i <= count * 4; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("4");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items4.add(item);
        }
        itemListMap.put("4", items4);

        List<Item> items5 = new ArrayList<>();
        for (int i = count * 4 + 1; i <= count * 5; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("5");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items5.add(item);
        }
        itemListMap.put("5", items5);

        List<Item> items6 = new ArrayList<>();
        for (int i = count * 5 + 1; i <= count * 6; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("6");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items6.add(item);
        }
        itemListMap.put("6", items6);

        List<Item> items7 = new ArrayList<>();
        for (int i = count * 6 + 1; i <= count * 7; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("7");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items7.add(item);
        }
        itemListMap.put("7", items7);

        List<Item> items8 = new ArrayList<>();
        for (int i = count * 7 + 1; i <= count * 8; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("8");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items8.add(item);
        }
        itemListMap.put("8", items8);

        List<Item> items9 = new ArrayList<>();
        for (int i = count * 8 + 1; i <= count * 9; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("9");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items9.add(item);
        }
        itemListMap.put("9", items9);

        List<Item> items10 = new ArrayList<>();
        for (int i = count * 9 + 1; i <= count * 10; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("10");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items10.add(item);
        }
        itemListMap.put("10", items10);

        List<Item> items11 = new ArrayList<>();
        for (int i = count * 10 + 1; i <= count * 11; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("11");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items11.add(item);
        }
        itemListMap.put("11", items11);

        List<Item> items12 = new ArrayList<>();
        for (int i = count * 11 + 1; i <= count * 12; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("12");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items12.add(item);
        }
        itemListMap.put("12", items12);

        List<Item> items13 = new ArrayList<>();
        for (int i = count * 12 + 1; i <= count * 13; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("13");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items13.add(item);
        }
        itemListMap.put("13", items13);

        List<Item> items14 = new ArrayList<>();
        for (int i = count * 14 + 1; i <= count * 15; i++) {
            Item item = new Item();
            item.setItemId(String.valueOf(i));
            item.setPrimaryCatalogId("14");
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setName("Item" + i);
            itemDetail.setPrice("¥" + i * 100);
            item.setItemDetail(itemDetail);
            items14.add(item);
        }
        itemListMap.put("14", items14);

        return itemListMap;
    }

}
