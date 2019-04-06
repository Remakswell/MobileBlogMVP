package com.example.mobileblogmvp.Main;
import com.example.mobileblogmvp.ApiClient;
import com.example.mobileblogmvp.ApiInterface;
import com.example.mobileblogmvp.Models.AuthorizationResponse;
import com.example.mobileblogmvp.Models.ProjectsResponse;
import java.util.List;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


public class FindItemsInteractor {

    private MainView mainView;
    private final ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
    private AuthorizationResponse authorizationResponse = new AuthorizationResponse();

    public FindItemsInteractor(MainView mainView){
        this.mainView = mainView;
    }

    public void createProjectList() {
        apiInterface.getProjects("en", "Bearer " + mainView.getToken())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<ProjectsResponse>>() {
                    @Override
                   public void onNext(List<ProjectsResponse> projectsResponses) {
                        mainView.setItems(projectsResponses);
                        mainView.hideProgress();
                   }

                   @Override
                   public void onError(Throwable e) {

                   }

                   @Override
                   public void onComplete() {

                   }
               });
    }
}
