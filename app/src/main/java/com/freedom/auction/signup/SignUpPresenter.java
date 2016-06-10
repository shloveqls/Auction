package com.freedom.auction.signup;

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

public class SignUpPresenter implements SignUpContract.Presenter {

    private final UserDataSource mUserDataSource;

    private final SignUpContract.View mSignUpView;

    public SignUpPresenter(@NonNull UserDataSource userDataSource,
                           @NonNull SignUpContract.View signUpView) {
        mUserDataSource = userDataSource;
        mSignUpView = signUpView;
        mSignUpView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void signUp(EditText nameText, EditText emailText, EditText passwordText) {

        if (!validate(nameText, emailText, passwordText)) {
            mSignUpView.showFailedSignUp();
            return;
        }

        mSignUpView.setSignUpButton(false);
        mSignUpView.setLoadingIndicator(true);

        String name = nameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        mUserDataSource.addUser(name, email, password,
                new BaseListener<UserRes>() {
                    
                    @Override
                    public void onResponse(UserRes response) {

                        mSignUpView.setLoadingIndicator(false);

                        if (response != null && TextUtils.isEmpty(response.getError())) {
                            if (response.getResult()) {
                                mSignUpView.showTop();
                            } else {
                                mSignUpView.showFailedSignUp();
                            }
                        } else {
                            mSignUpView.showFailedSignUp();
                        }

                    }

                });

    }

    private boolean validate(EditText nameText, EditText emailText, EditText passwordText) {
        boolean result = true;

        String name = nameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();

        if (TextUtils.isEmpty(name) || name.length() < 3) {
            nameText.setError(ActivityUtils.getResource(getContext(), R.string.name_error, String.class));
            result = false;
        } else {
            nameText.setError(null);
        }

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
        return ((Fragment) mSignUpView).getContext();
    }
}
