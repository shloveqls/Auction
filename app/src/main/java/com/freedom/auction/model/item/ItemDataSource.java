package com.freedom.auction.model.item;

import android.support.annotation.NonNull;

import com.freedom.auction.model.BaseListener;

public interface ItemDataSource {

    void getAllItems(@NonNull String catalogId, @NonNull BaseListener listener);

}
