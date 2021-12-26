package com.ellocart.ellocartapp.viewholder;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ellocart.ellocartapp.R;
import com.ellocart.ellocartapp.adapter.BannerAdapter;
import com.ellocart.ellocartapp.adapter.StoreAdapter;
import com.ellocart.ellocartapp.adapter.StoreCategoryAdapter;
import com.ellocart.ellocartapp.modal.CategoryItem;

import java.util.ArrayList;

public class VH_CategoryStore extends RecyclerView.ViewHolder {

    private RecyclerView rvStores;
    private LinearLayoutManager layoutManagerStores;
    private StoreCategoryAdapter storeCategoryAdapter;
    public VH_CategoryStore(@NonNull View itemView) {
        super(itemView);
        rvStores = itemView.findViewById(R.id.rv_store_categories);
    }

    public void loadStores(ArrayList<CategoryItem> categoryItems, Context context) {
        layoutManagerStores = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        rvStores.setLayoutManager(layoutManagerStores);
        storeCategoryAdapter = new StoreCategoryAdapter(context, categoryItems);
        rvStores.setAdapter(storeCategoryAdapter);
    }
}
