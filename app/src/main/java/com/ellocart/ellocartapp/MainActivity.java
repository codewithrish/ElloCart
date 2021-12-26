package com.ellocart.ellocartapp;

import static com.android.volley.Request.Method.POST;
import static com.ellocart.ellocartapp.util.AppConstants.ALL_INDIA;
import static com.ellocart.ellocartapp.util.AppConstants.ALL_INDIA_BANNERS;
import static com.ellocart.ellocartapp.util.AppConstants.ALL_INDIA_C;
import static com.ellocart.ellocartapp.util.AppConstants.ALL_INDIA_CATEGORIES;
import static com.ellocart.ellocartapp.util.AppConstants.BANNERS;
import static com.ellocart.ellocartapp.util.AppConstants.CATEGORIES;
import static com.ellocart.ellocartapp.util.AppConstants.HOME;
import static com.ellocart.ellocartapp.util.AppConstants.HOME_BANNERS;
import static com.ellocart.ellocartapp.util.AppConstants.KMS;
import static com.ellocart.ellocartapp.util.AppConstants.LOCAL;
import static com.ellocart.ellocartapp.util.AppConstants.LOCAL_CATEGORIES;
import static com.ellocart.ellocartapp.util.AppConstants.OFFER;
import static com.ellocart.ellocartapp.util.AppConstants.OFFERS_CATEGORIES;
import static com.ellocart.ellocartapp.util.AppConstants.PROFESSIONAL;
import static com.ellocart.ellocartapp.util.AppConstants.PROFESSIONAL_BANNERS;
import static com.ellocart.ellocartapp.util.AppConstants.STORE;
import static com.ellocart.ellocartapp.util.AppConstants.STORE_CATEGORIES;
import static com.ellocart.ellocartapp.util.AppConstants.USER_ID;
import static com.ellocart.ellocartapp.util.AppConstants.USER_LAT;
import static com.ellocart.ellocartapp.util.AppConstants.USER_LONG;
import static com.ellocart.ellocartapp.util.AppConstants.USER_TYPE;
import static com.ellocart.ellocartapp.util.AppConstants.bannersUrl;
import static com.ellocart.ellocartapp.util.AppConstants.categoryUrl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.android.volley.toolbox.StringRequest;
import com.ellocart.ellocartapp.adapter.HomeAdapter;
import com.ellocart.ellocartapp.app.AppController;
import com.ellocart.ellocartapp.modal.Banner;
import com.ellocart.ellocartapp.modal.BannerItem;
import com.ellocart.ellocartapp.modal.Category;
import com.ellocart.ellocartapp.modal.CategoryItem;
import com.ellocart.ellocartapp.util.ParseJson;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    private ShimmerFrameLayout mShimmerViewContainer;

    private HomeAdapter homeAdapter;
    List<Object> homeItems = new ArrayList<>();
    List<Object> newHomeItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        loadBanners();
    }

    private void loadBanners() {
        mShimmerViewContainer.startShimmer();
        StringRequest stringRequest = new StringRequest(POST, bannersUrl,
                response -> {
                    loadCategories();

                    ArrayList<BannerItem> homeBanners;
                    ArrayList<BannerItem> professionalBanners;
                    ArrayList<BannerItem> allIndiaBanners;
                    try {
                        JSONObject responseData = new JSONObject(response);

                        homeBanners = ParseJson.parseBanner(responseData, HOME_BANNERS);
                        professionalBanners = ParseJson.parseBanner(responseData, PROFESSIONAL_BANNERS);
                        allIndiaBanners = ParseJson.parseBanner(responseData, ALL_INDIA_BANNERS);

                        Banner homeBanner = new Banner();
                        Banner professionalBanner = new Banner();
                        Banner allIndiaBanner = new Banner();

                        homeBanner.setBanners(homeBanners);
                        professionalBanner.setBanners(professionalBanners);
                        allIndiaBanner.setBanners(allIndiaBanners);

                        homeBanner.setType(HOME);
                        professionalBanner.setType(PROFESSIONAL);
                        allIndiaBanner.setType(ALL_INDIA);

                        homeItems.add(homeBanner);
                        homeItems.add(professionalBanner);
                        homeItems.add(allIndiaBanner);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                },
                error -> Log.d("TAG", "onErrorResponse: ")) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(USER_ID, "66");
                params.put(USER_TYPE, "seller");
                params.put(USER_LAT, "17.0053223");
                params.put(USER_LONG, "81.7837962");
                return  params;
            }
        };

        AppController.getInstance().addToRequestQueue(stringRequest, BANNERS);
    }

    private void loadCategories() {
        StringRequest stringRequest = new StringRequest(POST, categoryUrl,
                response -> {

                    mShimmerViewContainer.stopShimmer();
                    mShimmerViewContainer.setVisibility(View.INVISIBLE);

                    ArrayList<CategoryItem> localCategories;
                    ArrayList<CategoryItem> allIndiaCategories;
                    ArrayList<CategoryItem> storeCategories;
                    ArrayList<CategoryItem> offerCategories;

                    try {
                        JSONObject responseData = new JSONObject(response);

                        localCategories = ParseJson.parseCategory(responseData, LOCAL_CATEGORIES);
                        allIndiaCategories = ParseJson.parseCategory(responseData, ALL_INDIA_CATEGORIES);
                        storeCategories = ParseJson.parseCategory(responseData, STORE_CATEGORIES);
                        offerCategories = ParseJson.parseCategory(responseData, OFFERS_CATEGORIES);

                        Category localCategory = new Category();
                        Category allIndiaCategory = new Category();
                        Category storeCategory = new Category();
                        Category offerCategory = new Category();

                        localCategory.setStatus(responseData.getString("status"));
                        allIndiaCategory.setStatus(responseData.getString("status_2"));
                        storeCategory.setStatus(responseData.getString("status_3"));
                        offerCategory.setStatus(responseData.getString("status_4"));

                        localCategory.setCategoriesClr(responseData.getString("categories_clr"));
                        allIndiaCategory.setCategoriesClr(responseData.getString("categories_2_clr"));
                        storeCategory.setCategoriesClr(responseData.getString("categories_3_clr"));
                        offerCategory.setCategoriesClr(responseData.getString("categories_4_clr"));

                        localCategory.setCategoriesH1(responseData.getString("categories_h1"));
                        allIndiaCategory.setCategoriesH1(responseData.getString("categories_2_h1"));
                        storeCategory.setCategoriesH1(responseData.getString("categories_3_h1"));
                        offerCategory.setCategoriesH1(responseData.getString("categories_4_h1"));

                        localCategory.setCategoriesH2(responseData.getString("categories_h2"));
                        allIndiaCategory.setCategoriesH2(responseData.getString("categories_2_h2"));
                        storeCategory.setCategoriesH2(responseData.getString("categories_3_h2"));
                        offerCategory.setCategoriesH2(responseData.getString("categories_4_h2"));

                        localCategory.setCategories(localCategories);
                        allIndiaCategory.setCategories(allIndiaCategories);
                        storeCategory.setCategories(storeCategories);
                        offerCategory.setCategories(offerCategories);

                        localCategory.setType(LOCAL);
                        allIndiaCategory.setType(ALL_INDIA_C);
                        storeCategory.setType(STORE);
                        offerCategory.setType(OFFER);

                        homeItems.add(localCategory);
                        homeItems.add(storeCategory);
                        homeItems.add(allIndiaCategory);

                        newHomeItems.add(homeItems.get(0));
                        homeAdapter.notifyItemInserted(newHomeItems.size() - 1);
                        newHomeItems.add(homeItems.get(3));
                        homeAdapter.notifyItemInserted(newHomeItems.size() - 1);
                        newHomeItems.add(homeItems.get(1));
                        homeAdapter.notifyItemInserted(newHomeItems.size() - 1);
                        newHomeItems.add(homeItems.get(4));
                        homeAdapter.notifyItemInserted(newHomeItems.size() - 1);
                        newHomeItems.add(homeItems.get(2));
                        homeAdapter.notifyItemInserted(newHomeItems.size() - 1);
                        newHomeItems.add(homeItems.get(5));
                        homeAdapter.notifyItemInserted(newHomeItems.size() - 1);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Log.d("TAG", "onErrorResponse: " + "stringreq")) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put(USER_LAT, "17.0271064");
                params.put(USER_LONG, "81.7931117");
                params.put(KMS, "10");
                return  params;
            }
        };

        AppController.getInstance().addToRequestQueue(stringRequest, CATEGORIES);
    }

    private void initViews() {
        mShimmerViewContainer = findViewById(R.id.shimmer_view_container);
        RecyclerView rvHomeItems = findViewById(R.id.rv_home_items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        homeAdapter = new HomeAdapter(this, newHomeItems);
        rvHomeItems.setLayoutManager(linearLayoutManager);
        rvHomeItems.setAdapter(homeAdapter);
    }

}