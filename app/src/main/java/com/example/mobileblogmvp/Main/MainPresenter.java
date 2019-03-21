package com.example.mobileblogmvp.Main;



public class MainPresenter {

    private MainView mainView;
    private FindItemsInteractor findItemsInteractor;

    public MainPresenter(MainView mainView, FindItemsInteractor findItemsInteractor) {
        this.findItemsInteractor = findItemsInteractor;
        this.mainView = mainView;
    }


    void onDestroy() {
        mainView = null;
    }

    void onResume() {
        if (mainView != null) {
            mainView.showProgress();
        }
        findItemsInteractor.createProjectList();
    }
}


