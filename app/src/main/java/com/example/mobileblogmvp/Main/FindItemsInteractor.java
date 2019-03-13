package com.example.mobileblogmvp.Main;

import android.util.Log;

import com.example.mobileblogmvp.ApiClient;
import com.example.mobileblogmvp.ApiInterface;
import com.example.mobileblogmvp.Models.ProjectsResponse;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FindItemsInteractor {

    private List<ProjectsResponse> projects;
    private MainView mainView;
    private final ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

    public FindItemsInteractor(MainView mainView){
        this.mainView = mainView;
    }

    public void createProjectList() {
        Call<List<ProjectsResponse>> getProjectsCall = apiInterface.
                getProjects("en", "Bearer " + mainView.getToken());

        getProjectsCall.enqueue(new Callback<List<ProjectsResponse>>() {
            @Override
            public void onResponse(Call<List<ProjectsResponse>> call, Response<List<ProjectsResponse>> response) {

                projects = response.body();

                if (mainView != null){
                    mainView.setItems(projects);
                    mainView.hideProgress();
                }
            }

            @Override
            public void onFailure(Call<List<ProjectsResponse>> call, Throwable t) {
                Log.d("test", "Error - " + t.getMessage());
            }
        });
    }
}
