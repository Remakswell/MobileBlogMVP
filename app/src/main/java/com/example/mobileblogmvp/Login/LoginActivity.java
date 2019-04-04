package com.example.mobileblogmvp.Login;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.example.mobileblogmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private ProgressBar progressBar;
    private TextInputLayout username;
    private TextInputLayout password;
    private TextView textView;
    private Button getStarted;
    private LoginPresenter presenter;
    private Context mContext = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.progress);
        username = findViewById(R.id.text_input_email);
        password = findViewById(R.id.text_input_password);
        textView = findViewById(R.id.tViewForgotPassword);
        getStarted = findViewById(R.id.buttonGetStarted);

        presenter = new LoginPresenter(this, new LoginInteractor());

        //Underline text
        SpannableString content = new SpannableString("Forgot your password?");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);

        getStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.validateCredentials();
            }
        });
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
        presenter.validateCredentials(username.getEditText().getText().toString(),
                password.getEditText().getText().toString());
    }
}
