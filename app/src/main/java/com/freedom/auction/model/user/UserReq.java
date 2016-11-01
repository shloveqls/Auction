package com.freedom.auction.model.user;

public class UserReq {

    private String mName;

    private String mEmail;

    private String mPassword;

    public UserReq(String name, String email, String password) {
        this.mName = name;
        this.mEmail = email;
        this.mPassword = password;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        this.mEmail = email;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        this.mPassword = password;
    }

    @Override
    public String toString() {
        return "UserReq{" +
                "name='" + mName + '\'' +
                ", email='" + mEmail + '\'' +
                ", password='" + mPassword + '\'' +
                '}';
    }
}
