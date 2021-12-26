package com.ellocart.ellocartapp.util;

import static com.ellocart.ellocartapp.util.AppConstants.HOME_BANNERS;

import com.ellocart.ellocartapp.modal.BannerItem;
import com.ellocart.ellocartapp.modal.CategoryItem;
import com.ellocart.ellocartapp.modal.CategoryItemSeller;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParseJson {

    private static Gson gson = new Gson();

    public static ArrayList<BannerItem> parseBanner(JSONObject responseData, String type) {
        ArrayList<BannerItem> bannerItems = new ArrayList<>();
        JSONArray bannersArray = null;
        try {
            bannersArray = responseData.getJSONArray(type);
            for (int i = 0; i < bannersArray.length(); i++) {
                JSONObject bannerObj = bannersArray.getJSONObject(i);
                BannerItem bannerItem = gson.fromJson(bannerObj.toString(), BannerItem.class);
                bannerItems.add(bannerItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bannerItems;
    }

    public static ArrayList<CategoryItem> parseCategory(JSONObject responseData, String type) {
        ArrayList<CategoryItem> categoryItems = new ArrayList<>();
        JSONArray categoriesArray = null;
        try {
            categoriesArray = responseData.getJSONArray(type);
            for (int i = 0; i < categoriesArray.length(); i++) {
                JSONObject bannerObj = categoriesArray.getJSONObject(i);
                CategoryItem bannerItem = gson.fromJson(bannerObj.toString(), CategoryItem.class);
                categoryItems.add(bannerItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return categoryItems;
    }
}
