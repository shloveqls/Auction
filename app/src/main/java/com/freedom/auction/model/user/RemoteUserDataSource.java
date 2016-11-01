package com.freedom.auction.model.user;

import android.support.annotation.NonNull;

import com.freedom.auction.model.BaseListener;
import com.freedom.auction.model.http.HttpGetAsyncTask;
import com.freedom.auction.model.http.HttpPostAsyncTask;

public class RemoteUserDataSource implements UserDataSource {

    private static final RemoteUserDataSource INSTANCE = new RemoteUserDataSource();

    private RemoteUserDataSource() {

    }

    public static RemoteUserDataSource getInstance() {
        return RemoteUserDataSource.INSTANCE;
    }

    public void checkUser(@NonNull String email, @NonNull String password,
                          @NonNull BaseListener<UserRes> listener) {

        // TODO
        String url = "/users/auth";
        UserReq user = new UserReq("", email, password);

        // TODO change user object to json format
        new HttpPostAsyncTask<UserRes>(listener, UserRes.class).execute(url, user.toString());

    }

    public void addUser(@NonNull String name, @NonNull String email,
                        @NonNull String password, @NonNull BaseListener<UserRes> listener) {

        // TODO
        String url = "/users/new";
        UserReq user = new UserReq(name, email, password);

        // TODO change user object to json format
        new HttpPostAsyncTask<UserRes>(listener, UserRes.class).execute(url, user.toString());

    }

}
