package com.example.mobileblogmvp.Main;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainPresenter implements FindItemsInteractor.OnFinishedListener {


    private MainView mainView;
    private FindItemsInteractor findItemsInteractor;

    public MainPresenter(MainView mainView, FindItemsInteractor findItemsInteractor) {
        this.mainView = mainView;
        this.findItemsInteractor = findItemsInteractor;
    }

}
