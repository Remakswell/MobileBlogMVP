package com.example.mobileblogmvp;

import com.example.mobileblogmvp.Models.AuthorizationResponse;
import com.example.mobileblogmvp.Models.ProjectsResponse;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("/api/v1/projects/my/teams")
    Observable<List<ProjectsResponse>> getProjects(@Header("Accept-Language") String headerLanguage,
                                                       @Header("Authorization") String headerToken);


    @POST("/api/v1/security/auth/email")
    Call<AuthorizationResponse> authorizationRequest(@Header ("Accept-Language") String headerLanguage,
                                                     @Header("Authorization") String headerToken,
                                                     @Body HashMap<String,Object> body);
}
