package com.example.mobileblogmvp.Login;

import android.content.Context;

public interface LoginView {

    void showProgress();

    void hideProgress();

    void validateUsername();

    void validatePassword();

    Context getContext();

    String getName();

    String getPassword();

}
