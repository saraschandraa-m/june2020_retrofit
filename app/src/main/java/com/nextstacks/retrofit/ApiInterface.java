package com.nextstacks.retrofit;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {


    /**
     * 1. Get
     * 2. Post
     * 3. Put
     * 4. Delete
     */

    //http://newsapi.org/v2/everything?q=bitcoin&from=2020-08-07&sortBy=publishedAt&apiKey=4c82d7e8131841f484c6cf169bb83ae4


    //This is for scalar
//    @GET("v2/everything/")
//    Call<String> getNews(@QueryMap HashMap<String, Object> queries);
    @GET("v2/everything/")
    Call<Result> getNews(@QueryMap HashMap<String, Object> queries);


    @GET("v2/top-headlines/")
    Call<Result> getTopHeadlines(@QueryMap HashMap<String, Object> queries);

}
