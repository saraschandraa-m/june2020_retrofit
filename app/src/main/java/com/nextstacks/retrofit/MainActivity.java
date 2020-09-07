package com.nextstacks.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onGetDataClicked(View view) {


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);


        HashMap<String, Object> queries = new HashMap<>();

        queries.put("apiKey", "4c82d7e8131841f484c6cf169bb83ae4");
        queries.put("sources", "google-news");


//        Call<String> getNews = apiInterface.getNews(queries);
//
//        getNews.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.i("API Call", "Success");
//
//                String responseValue = response.body();
//                Log.i("Response", responseValue);
//
//                try {
//                    JSONObject responseObject = new JSONObject(responseValue);
//                    Result resultValue = Result.parseResponse(responseObject);
//
//
//                    ArrayList<Article> articles = resultValue.articles;
//
//                    runOnUiThread(() -> Toast.makeText(MainActivity.this, resultValue.articles.size() + "", Toast.LENGTH_SHORT).show());
//
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                Log.i("API Call", "Failed");
//            }
//        });


        Call<Result> getNews = apiInterface.getNews(queries);

        getNews.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result = response.body();

                Toast.makeText(MainActivity.this, result.articles.size() + "", Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });


    }
}