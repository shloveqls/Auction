package com.freedom.auction.model.http;

import android.os.AsyncTask;
import android.util.Log;

import com.freedom.auction.model.BaseListener;

import java.lang.reflect.Method;

public abstract class HttpAsyncTask<Params, Res> extends AsyncTask<Params, Void, String> {

    private BaseListener<Res> mListener;

    private Class<Res> mClass;

    public HttpAsyncTask(BaseListener listener, Class cls) {
        mListener = listener;
        mClass = cls;
    }

    @Override
    protected void onPostExecute(String result) {
        Res res = null;
        try {
            Method parse = mClass.getMethod("parse", String.class);
            res = mClass.cast(parse.invoke(null, result));
        } catch (Exception e) {
            Log.d(HttpAsyncTask.class.getName(), e.getMessage());
        }
        mListener.onResponse(res);
    }

}
