package com.example.mobileblogmvp.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mobileblogmvp.Models.ProjectsResponse;
import com.example.mobileblogmvp.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setItems(List<ProjectsResponse> projects) {

    }

    @Override
    public void showProjectName(String projectName) {

    }
}
