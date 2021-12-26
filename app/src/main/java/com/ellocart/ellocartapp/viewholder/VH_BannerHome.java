package com.ellocart.ellocartapp.viewholder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.ellocart.ellocartapp.R;
import com.ellocart.ellocartapp.adapter.BannerAdapter;
import com.ellocart.ellocartapp.modal.BannerItem;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class VH_BannerHome extends RecyclerView.ViewHolder {
    public RecyclerView rvBanners;
    private LinearLayoutManager layoutManagerBanners;
    private BannerAdapter bannerAdapter;
    public VH_BannerHome(@NonNull View itemView) {
        super(itemView);
        rvBanners = itemView.findViewById(R.id.rv_home_sub_items);
    }

    public void loadBanners(ArrayList<BannerItem> bannerItems, Context context) {
        layoutManagerBanners = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rvBanners.setLayoutManager(layoutManagerBanners);
        bannerAdapter = new BannerAdapter(context, bannerItems);
        rvBanners.setAdapter(bannerAdapter);

        autoScrollBanners();
    }
    private void autoScrollBanners() {
        LinearSnapHelper snapHelper = new LinearSnapHelper();

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (layoutManagerBanners.findLastCompletelyVisibleItemPosition() < (bannerAdapter.getItemCount() - 1)) {
                    layoutManagerBanners.smoothScrollToPosition(rvBanners, new RecyclerView.State(), layoutManagerBanners.findLastCompletelyVisibleItemPosition() + 1);
                } else if (layoutManagerBanners.findLastCompletelyVisibleItemPosition() == (bannerAdapter.getItemCount() - 1)) {
                    layoutManagerBanners.smoothScrollToPosition(rvBanners, new RecyclerView.State(), 0);
                }
            }
        }, 0, 3000);
    }
}
