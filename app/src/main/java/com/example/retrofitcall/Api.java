package com.example.retrofitcall;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Milan Bamaniya on 7/15/2022.
 */
public interface Api {

    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Results>> getsuperHeros();
}
