package com.example.mobileblogmvp.Main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import com.example.mobileblogmvp.Models.ProjectsResponse;
import com.example.mobileblogmvp.R;
import java.util.List;
import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView.LayoutManager layoutManager;
    private MainAdapter adapter;
    private MainPresenter presenter;
    private String token;
    @BindView(R.id.list) RecyclerView recyclerView;
    @BindView(R.id.progress) ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MainAdapter(this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        progressBar = findViewById(R.id.progress);
        presenter = new MainPresenter(this, new FindItemsInteractor(this));

        Intent intent = getIntent();
        token = intent.getStringExtra("token");
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<ProjectsResponse> projects) {

        adapter.setItems(projects.get(0).projects);
        adapter.notifyDataSetChanged();
    }

    @Override
    public String getToken() {
        return token;
    }
}
