package com.freedom.auction.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.freedom.auction.R;
import com.freedom.auction.model.user.RemoteUserDataSource;
import com.freedom.auction.util.ActivityUtils;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        // Create the fragment
        LoginFragment loginFragment =
                (LoginFragment) getSupportFragmentManager().findFragmentById(R.id.frame_login);
        if (loginFragment == null) {
            loginFragment = LoginFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    loginFragment, R.id.frame_login);
        }

        // Create the presenter
        new LoginPresenter(RemoteUserDataSource.getInstance(), loginFragment);
    }

}
