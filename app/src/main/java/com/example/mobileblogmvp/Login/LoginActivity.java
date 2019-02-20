package com.example.mobileblogmvp.Login;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.mobileblogmvp.Main.MainActivity;
import com.example.mobileblogmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private Button getStarted;
    private LoginPresenter presenter;
    private Context mContext = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progress);
        username = findViewById(R.id.tesxt_input_email);
        password = findViewById(R.id.tesxt_input_password);
        getStarted = findViewById(R.id.buttonGetStarted);


        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.validateCredentials();
            }
        });
        presenter = new LoginPresenter(this, new LoginInteractor());
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void validateUsername() {
        username.setError(getString(R.string.username_error));
    }

    @Override
    public void validatePassword() {
        password.setError(getString(R.string.password_error));
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    private void validateCredentials(){
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
        Log.d("test", "ActivityLoginOK");
    }
}
