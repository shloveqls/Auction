package com.freedom.auction.login;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import com.freedom.auction.model.BaseListener;
import com.freedom.auction.R;
import com.freedom.auction.model.user.UserDataSource;
import com.freedom.auction.model.user.UserRes;
import com.freedom.auction.util.ActivityUtils;

public class LoginPresenter implements LoginContract.Presenter {

    private final UserDataSource mUserDataSource;

    private final LoginContract.View mLoginView;

    public LoginPresenter(@NonNull UserDataSource userDataSource,
                          @NonNull LoginContract.View loginView) {
        mUserDataSource = userDataSource;
        mLoginView = loginView;
        mLoginView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void login(EditText emailText, EditText passwordText) {

        if (!validate(emailText, passwordText)) {
            mLoginView.showFailedLogin();
            return;
        }

        mLoginView.setLoginButton(false);
        mLoginView.setLoadingIndicator(true);

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        mUserDataSource.checkUser(email, password,
                new BaseListener<UserRes>() {

                    @Override
                    public void onResponse(UserRes response) {

                        mLoginView.setLoadingIndicator(false);

                        if (response != null && TextUtils.isEmpty(response.getError())) {
                            if (response.getResult()) {
                                mLoginView.showTop();
                            } else {
                                mLoginView.showFailedLogin();
                            }
                        } else {
                            mLoginView.showFailedLogin();
                        }
                    }

                });

    }

    private boolean validate(EditText emailText, EditText passwordText) {
        boolean result = true;

        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError(ActivityUtils.getResource(getContext(), R.string.email_error, String.class));
            result = false;
        } else {
            emailText.setError(null);
        }

        if (TextUtils.isEmpty(password) || password.length() < 4 || password.length() > 10) {
            passwordText.setError(ActivityUtils.getResource(getContext(), R.string.password_error, String.class));
            result = false;
        } else {
            passwordText.setError(null);
        }

        return result;
    }

    private Context getContext() {
        return ((Fragment) mLoginView).getContext();
    }

}
