package com.example.mobileblogmvp.Login;

import android.content.Intent;
import android.util.Log;
import com.example.mobileblogmvp.Main.MainActivity;
import com.example.mobileblogmvp.Models.AuthorizationResponse;
import java.util.HashMap;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


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
        body.put("email", loginView.getName());         //owner@gmail.com
        body.put("password", loginView.getPassword());  //1234567a

        loginInteractor.apiInterface.authorizationRequest("en","Bearer", body )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<AuthorizationResponse>() {
                    @Override
                    public void onNext(AuthorizationResponse authorizationResponse) {

                        token = authorizationResponse.token;

                        if(token != null){
                            Intent intent = new Intent(loginView.getContext(), MainActivity.class);
                            intent.putExtra("token", token);
                            loginView.getContext().startActivity(intent);
                        } else{
                            Log.d("test","Error token");
                        }
                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                    @Override
                    public void onComplete() {

                    }
                });
    }
}
