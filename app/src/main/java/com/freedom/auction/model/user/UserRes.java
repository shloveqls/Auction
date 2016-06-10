package com.freedom.auction.model.user;

import com.freedom.auction.model.Res;

public class UserRes extends Res {

    public static UserRes parse(String response) {
        // TODO
        UserRes userRes = new UserRes();
        userRes.setResult(true);
        return userRes;
    }

}
