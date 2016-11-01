package com.freedom.auction.model;

public abstract class Res {

    private boolean mResult;

    private String mError;

    public boolean getResult() {
        return mResult;
    }

    public void setResult(boolean result) {
        this.mResult = result;
    }

    public String getError() {
        return mError;
    }

    public void setError(String error) {
        this.mError = error;
    }

    @Override
    public String toString() {
        return "Res{" +
                "result=" + mResult +
                ", error='" + mError + '\'' +
                '}';
    }

}
