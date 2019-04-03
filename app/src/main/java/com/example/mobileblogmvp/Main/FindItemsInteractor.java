package com.example.mobileblogmvp.Main;

import android.util.Log;

import com.example.mobileblogmvp.ApiClient;
import com.example.mobileblogmvp.ApiInterface;
import com.example.mobileblogmvp.BuildConfig;
import com.example.mobileblogmvp.Models.ProjectsResponse;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.method.TextKeyListener.Capitalize.NONE;
import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

public class FindItemsInteractor {

    private List<ProjectsResponse> projects;
    private MainView mainView;
    private final ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public FindItemsInteractor(MainView mainView){
        this.mainView = mainView;
    }



    public void createProjectList() {

        compositeDisposable.add(apiInterface.getProjects("en", "Bearer " + mainView.getToken()).
                subscribeOn(Schedulers.io()).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<ProjectsResponse>>() {
                    @Override
                    public void accept(List<ProjectsResponse> projectsResponses) throws Exception {
                        mainView.setItems(projectsResponses);
                    }
                }));
    }
}
