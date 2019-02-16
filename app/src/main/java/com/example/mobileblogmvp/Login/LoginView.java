package com.example.mobileblogmvp.Login;

public interface LoginView {

    void showProgress();

    void hideProgress();

    void validateUsername();

    void validatePassword();

    void navigateToHome();

}
