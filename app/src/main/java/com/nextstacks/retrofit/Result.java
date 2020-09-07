package com.nextstacks.retrofit;

import com.google.gson.annotations.SerializedName;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Result {

    @SerializedName("status")
    public String status;
    @SerializedName("totalResults")
    public int totalResults;

    @SerializedName("articles")
    public ArrayList<Article> articles;


//    public static Result parseResponse(JSONObject jsonObject) {
//        Result item = new Result();
//
//
//        item.status = jsonObject.optString("status");
//        item.totalResults = jsonObject.optInt("totalResults");
//
//        item.articles = new ArrayList<>();
//        JSONArray articlesArray = jsonObject.optJSONArray("articles");
//
//        if (articlesArray != null && articlesArray.length() > 0) {
//            for (int i = 0; i < articlesArray.length(); i++) {
//                JSONObject articleObject = articlesArray.optJSONObject(i);
//                Article articleItem = Article.parseArticleResponse(articleObject);
//
//                item.articles.add(articleItem);
//            }
//        }
//
//        return item;
//    }
}
