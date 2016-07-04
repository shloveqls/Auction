package com.freedom.auction.model.http;

import com.freedom.auction.model.BaseListener;

public class HttpGetAsyncTask<Res> extends HttpAsyncTask<String, Res> {

    public HttpGetAsyncTask(BaseListener<Res> listener, Class<Res> cls) {
        super(listener, cls);
    }

    @Override
    protected String doInBackground(String... params) {
        // TODO
        return "";
    }

}
