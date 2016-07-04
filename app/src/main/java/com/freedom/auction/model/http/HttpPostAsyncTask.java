package com.freedom.auction.model.http;

import com.freedom.auction.model.BaseListener;

public class HttpPostAsyncTask<Res> extends HttpAsyncTask<String, Res> {

    public HttpPostAsyncTask(BaseListener<Res> listener, Class<Res> cls) {
        super(listener, cls);
    }

    @Override
    protected String doInBackground(String... params) {
        // TODO
        return "";
    }

}
