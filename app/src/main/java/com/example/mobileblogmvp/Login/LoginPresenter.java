package com.example.mobileblogmvp.Login;

import android.content.Intent;
import android.util.Log;


import com.example.mobileblogmvp.Main.MainActivity;
import com.example.mobileblogmvp.Models.AuthorizationResponse;

import java.util.HashMap;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private String token;

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

        HashMap<String, Object> body = new HashMap<>();
        body.put("email", "fed.lviv@gmail.com");
        body.put("password", "1234567a");

        //create login request
        final Call<AuthorizationResponse> authorizationCall = loginInteractor.apiInterface.
                authorizationRequest("en","Bearer", body);


        //launch login request
        authorizationCall.enqueue(new Callback<AuthorizationResponse>() {

            //triggered by successful request
            @Override
            public void onResponse(Call<AuthorizationResponse> call, Response<AuthorizationResponse> response) {

                token = response.body().token;
                Log.d("test", "Token Login2 - " + token);

                if(token != null){
                    Intent intent = new Intent(loginView.getContext(), MainActivity.class);
                    intent.putExtra("token", token);
                    loginView.getContext().startActivity(intent);
                } else{
                    Log.d("test","Error token");
                }
            }

            @Override
            public void onFailure(Call<AuthorizationResponse> call, Throwable t) {
                Log.d("test", "Error - " + t.getMessage());
            }
        });
    }
}
