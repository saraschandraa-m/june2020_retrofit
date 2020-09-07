package com.nextstacks.retrofit;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class Article {

    @SerializedName("author")
    public String mAuthor;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;
    public String content;
    public Source source;


//    public static Article parseArticleResponse(JSONObject jsonObject){
//        Article articleItem = new Article();
//        articleItem.author = jsonObject.optString("author");
//        articleItem.title = jsonObject.optString("title");
//        articleItem.description = jsonObject.optString("description");
//        articleItem.url = jsonObject.optString("url");
//        articleItem.urlToImage = jsonObject.optString("urlToImage");
//        articleItem.publishedAt = jsonObject.optString("publishedAt");
//        articleItem.content = jsonObject.optString("content");
//
//        JSONObject sourceObject = jsonObject.optJSONObject("source");
//        articleItem.source = Source.parseSourceResponse(sourceObject);
//
//
//
////        articleItem.source = Source.parseSourceResponse(jsonObject.optJSONObject("source"));
//        return articleItem;
//    }
}
