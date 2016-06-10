package com.freedom.auction.signup;

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
import com.freedom.auction.login.LoginActivity;
import com.freedom.auction.top.TopActivity;
import com.freedom.auction.util.ActivityUtils;

public class SignUpFragment extends Fragment implements SignUpContract.View {

    private SignUpContract.Presenter mSignUpPresenter;

    private EditText mInputName;

    private EditText mInputEmail;

    private EditText mInputPassword;

    private AppCompatButton mBtnSignUp;

    private TextView mLinkLogin;

    private ProgressDialog mProgressDialog;

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_sign_up, container, false);

        mInputName = (EditText) root.findViewById(R.id.input_name);
        mInputEmail = (EditText) root.findViewById(R.id.input_email);
        mInputPassword = (EditText) root.findViewById(R.id.input_password);
        mBtnSignUp = (AppCompatButton) root.findViewById(R.id.btn_sign_up);
        mLinkLogin = (TextView) root.findViewById(R.id.link_login);

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSignUpPresenter.signUp(mInputName, mInputEmail, mInputPassword);
            }
        });

        mLinkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogin();
            }
        });

        createProgressDialog();

        return root;
    }

    @Override
    public void setPresenter(SignUpContract.Presenter presenter) {
        mSignUpPresenter = presenter;
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
    public void setSignUpButton(boolean enable) {
        if (mBtnSignUp != null) {
            mBtnSignUp.setEnabled(enable);
        }
    }

    @Override
    public void showLogin() {
        Intent intent = new Intent(getContext(), LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void showTop() {
        Intent intent = new Intent(getContext(), TopActivity.class);
        startActivity(intent);
    }

    @Override
    public void showFailedSignUp() {
        Toast.makeText(getContext(), ActivityUtils.getResource(getContext(), R.string.sign_up_failed, String.class),
                Toast.LENGTH_LONG).show();
        mBtnSignUp.setEnabled(true);
    }

    private void createProgressDialog() {
        mProgressDialog = new ProgressDialog(getContext(), R.style.AppTheme_Dark_Dialog);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage(ActivityUtils.getResource(getContext(), R.string.dialog_loading, String.class));
    }

}
