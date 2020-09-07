package com.nextstacks.retrofit;

import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

public class Source {

    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;


//    public static Source parseSourceResponse(JSONObject jsonObject) {
//        Source sourceItem = new Source();
//
//        sourceItem.id = jsonObject.optString("id");
//        sourceItem.name = jsonObject.optString("name");
//        return sourceItem;
//    }
}
