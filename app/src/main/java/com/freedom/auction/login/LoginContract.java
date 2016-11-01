package com.freedom.auction.login;

import android.widget.EditText;

import com.freedom.auction.BasePresenter;
import com.freedom.auction.BaseView;

public interface LoginContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void setLoginButton(boolean enable);

        void showSignUp();

        void showTop();

        void showFailedLogin();

    }

    interface Presenter extends BasePresenter {

        void login(EditText emailText, EditText passwordText);

    }

}
