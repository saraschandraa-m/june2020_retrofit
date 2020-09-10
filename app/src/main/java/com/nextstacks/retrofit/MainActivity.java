package com.nextstacks.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.CategoryClickListener {


    private RecyclerView mRcCategories;
    private RecyclerView mRcNews;

    private String categoryValue = "business";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRcCategories = findViewById(R.id.rc_news_categories);
        mRcCategories.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL, false));

        mRcNews = findViewById(R.id.rc_news);
        mRcNews.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));

        CategoryAdapter categoryAdapter = new CategoryAdapter(MainActivity.this);
        categoryAdapter.setListener(this);
        mRcCategories.setAdapter(categoryAdapter);

        loadTopHeadlines();
    }


    private void loadTopHeadlines() {

        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Getting your news");
        progressDialog.show();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        HashMap<String, Object> queries = new HashMap<>();
        queries.put("apiKey", "4c82d7e8131841f484c6cf169bb83ae4");
        queries.put("category", categoryValue);

        Call<Result> getTopHeadlines = apiInterface.getTopHeadlines(queries);

        getTopHeadlines.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                progressDialog.hide();
                Result value = response.body();

                ArrayList<Article> articles = value.articles;

                NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, articles);
                mRcNews.setAdapter(newsAdapter);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                progressDialog.hide();

            }
        });

        //https://newsapi.org/v2/top-headlines/?apiKey=4c82d7e8131841f484c6cf169bb83ae4&category=general


//        new backgroundWork().execute();
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

    class backgroundWork extends AsyncTask<Void, String, String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... voids) {

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }

    @Override
    public void onCategoryClicked(String categoryname) {
        categoryValue = categoryname;
        loadTopHeadlines();
    }
}