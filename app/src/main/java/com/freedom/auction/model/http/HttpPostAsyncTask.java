package com.freedom.auction.model.http;

import com.freedom.auction.model.BaseListener;

public class HttpPostAsyncTask<Res> extends HttpAsyncTask<String, Res> {

    public HttpPostAsyncTask(BaseListener listener, Class cls) {
        super(listener, cls);
    }

    @Override
    protected String doInBackground(String... params) {
        // TODO
        return "";
    }

}
