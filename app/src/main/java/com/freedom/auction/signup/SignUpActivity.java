package com.freedom.auction.signup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.freedom.auction.R;
import com.freedom.auction.model.user.RemoteUserDataSource;
import com.freedom.auction.util.ActivityUtils;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

        SignUpFragment signUpFragment =
                (SignUpFragment) getSupportFragmentManager().findFragmentById(R.id.frame_sign_up);
        if (signUpFragment == null) {
            signUpFragment = SignUpFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    signUpFragment, R.id.frame_sign_up);
        }

        new SignUpPresenter(RemoteUserDataSource.getInstance(), signUpFragment);

    }

}
