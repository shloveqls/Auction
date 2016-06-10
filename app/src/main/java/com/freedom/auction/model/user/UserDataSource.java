package com.freedom.auction.model.user;

import android.support.annotation.NonNull;

import com.freedom.auction.model.BaseListener;

public interface UserDataSource {

    void checkUser(@NonNull String email, @NonNull String password, @NonNull BaseListener listener);

    void addUser(@NonNull String name, @NonNull String email, @NonNull String password, @NonNull BaseListener listener);

}
