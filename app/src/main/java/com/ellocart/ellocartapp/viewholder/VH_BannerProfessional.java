package com.ellocart.ellocartapp.viewholder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ellocart.ellocartapp.R;
import com.ellocart.ellocartapp.adapter.BannerAdapter;
import com.ellocart.ellocartapp.modal.BannerItem;

import java.util.ArrayList;

public class VH_BannerProfessional extends RecyclerView.ViewHolder {
    public RecyclerView rvBanners;
    private LinearLayoutManager layoutManagerBanners;
    private BannerAdapter bannerAdapter;
    public VH_BannerProfessional(@NonNull View itemView) {
        super(itemView);
        rvBanners = itemView.findViewById(R.id.rv_home_sub_items);
    }

    public void loadBanners(ArrayList<BannerItem> bannerItems, Context context) {
        layoutManagerBanners = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rvBanners.setLayoutManager(layoutManagerBanners);
        bannerAdapter = new BannerAdapter(context, bannerItems);
        rvBanners.setAdapter(bannerAdapter);
    }
}
