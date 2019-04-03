package com.example.mobileblogmvp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    public static final String BASE_URL = BuildConfig.SERVER_URL;

    public static Retrofit retrofit;

    public static Retrofit getApiClient() {
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        }

        return retrofit;
    }


//    fun <T> createService(clazz: Class<T>, tokenStorage: TokenLocalStorage) =
//
//            Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BuildConfig.SERVER_URL)
//        .client(OkHttpClient.Builder()
//                .addInterceptor(loggingInterceptor())
//            .addInterceptor(TokenInterceptor(tokenStorage))
//            .build())
//            .build()
//        .create(clazz)
//
//    private fun loggingInterceptor() = HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) BODY else NONE)




}
