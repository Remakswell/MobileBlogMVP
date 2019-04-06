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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{

    private LoginPresenter presenter;
    private Context mContext = this;
    @BindView(R.id.progress) ProgressBar progressBar;
    @BindView(R.id.text_input_email) TextInputLayout username;
    @BindView(R.id.text_input_password) TextInputLayout password;
    @BindView(R.id.tViewForgotPassword) TextView textView;
    @BindView(R.id.buttonGetStarted) Button getStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this, new LoginInteractor());

        //Underline text
        SpannableString content = new SpannableString("Forgot your password?");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        textView.setText(content);
    }

    @OnClick(R.id.buttonGetStarted)
    public void getStartedButtonClick(){
        LoginActivity.this.validateCredentials();
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

    @Override
    public String getName(){
        return username.getEditText().getText().toString();
    }

    @Override
    public String getPassword(){
        return password.getEditText().getText().toString();
    }

    private void validateCredentials(){
        presenter.validateCredentials(getName(), getPassword());
    }
}
