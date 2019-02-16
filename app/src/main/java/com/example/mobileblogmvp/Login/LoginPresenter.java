package com.example.mobileblogmvp.Login;

import android.content.Context;
import android.util.Log;
import android.util.Patterns;

import java.util.regex.Pattern;

public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

//    private Context mContext = this;

    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void onDestroy() {
        loginView = null;
    }

    public void validateCredentials(String username, String password) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginInteractor.login(username, password, this);
    }




    @Override
    public void validateUsername() {
        if (loginView != null) {
            loginView.validateUsername();
            loginView.hideProgress();
        }



    }

    @Override
    public void validatePassword() {
        if (loginView != null) {
            loginView.validatePassword();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if(loginView != null){
            loginView.navigateToHome();
        }
    }
}
