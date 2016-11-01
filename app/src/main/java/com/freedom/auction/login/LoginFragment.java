package com.freedom.auction.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.freedom.auction.R;
import com.freedom.auction.signup.SignUpActivity;
import com.freedom.auction.top.TopActivity;
import com.freedom.auction.util.ActivityUtils;

public class LoginFragment extends Fragment implements LoginContract.View {

    private LoginContract.Presenter mLoginPresenter;

    private EditText mInputEmail;

    private EditText mInputPassword;

    private AppCompatButton mBtnLogin;

    private TextView mLinkSignUp;

    private ProgressDialog mProgressDialog;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_login, container, false);

        mInputEmail = (EditText) root.findViewById(R.id.input_email);
        mInputPassword = (EditText) root.findViewById(R.id.input_password);
        mBtnLogin = (AppCompatButton) root.findViewById(R.id.btn_login);
        mLinkSignUp = (TextView) root.findViewById(R.id.link_signup);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.login(mInputEmail, mInputPassword);
            }
        });

        mLinkSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignUp();
            }
        });

        createProgressDialog();

        return root;

    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        mLoginPresenter = presenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (mProgressDialog != null) {
            if (active) {
                mProgressDialog.show();
            } else {
                mProgressDialog.dismiss();
            }
        }
    }

    @Override
    public void setLoginButton(boolean enable) {
        if (mBtnLogin != null) {
            mBtnLogin.setEnabled(enable);
        }
    }

    @Override
    public void showSignUp() {
        Intent intent = new Intent(getContext(), SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void showTop() {
        Intent intent = new Intent(getContext(), TopActivity.class);
        startActivity(intent);
    }

    @Override
    public void showFailedLogin() {
        Toast.makeText(getContext(), ActivityUtils.getResource(getContext(), R.string.login_failed, String.class),
                Toast.LENGTH_LONG).show();
        mBtnLogin.setEnabled(true);
    }

    private void createProgressDialog() {
        mProgressDialog = new ProgressDialog(getContext(), R.style.AppTheme_Dark_Dialog);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(ActivityUtils.getResource(getContext(), R.string.dialog_loading, String.class));
    }

}
