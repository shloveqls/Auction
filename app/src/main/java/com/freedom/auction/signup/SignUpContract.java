package com.freedom.auction.signup;

import android.widget.EditText;

import com.freedom.auction.BasePresenter;
import com.freedom.auction.BaseView;

public interface SignUpContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void setSignUpButton(boolean enable);

        void showLogin();

        void showTop();

        void showFailedSignUp();

    }

    interface Presenter extends BasePresenter {

        void signUp(EditText nameText, EditText emailText, EditText passwordText);

    }

}
