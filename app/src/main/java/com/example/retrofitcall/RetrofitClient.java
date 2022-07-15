package com.example.retrofitcall;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Milan Bamaniya on 7/15/2022.
 */
public class RetrofitClient {

    private static RetrofitClient instance = null;
    private final Api myApi;

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        myApi = retrofit.create(Api.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null)
            instance = new RetrofitClient();
        return instance;
    }

    public Api getMyApi() {
        return myApi;
    }
}
