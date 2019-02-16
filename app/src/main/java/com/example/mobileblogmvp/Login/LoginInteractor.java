package com.example.mobileblogmvp.Login;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;

import java.util.regex.Pattern;

public class LoginInteractor {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    interface OnLoginFinishedListener {
        void validateUsername();

        void validatePassword();

        void onSuccess();
    }


    public void login(final String username, final String password, final OnLoginFinishedListener listener) {

        Log.d("test", "login ok");
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                if (TextUtils.isEmpty(username) || !Patterns.EMAIL_ADDRESS.matcher(username).matches()) {
                    listener.validateUsername();
                    return;
                }
                if (TextUtils.isEmpty(password) || !PASSWORD_PATTERN.matcher(password).matches()) {
                    listener.validatePassword();
                    return;
                }
                listener.onSuccess();
            }
        }, 2000);

    }



}
