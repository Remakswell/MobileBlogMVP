package com.example.mobileblogmvp.Main;

import com.example.mobileblogmvp.Models.ProjectsResponse;

import java.util.List;

public interface MainView {
    void showProgress();

    void hideProgress();

    void setItems(List<ProjectsResponse> projects);

    void showProjectName(String projectName);


}
