package com.ellocart.ellocartapp.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ellocart.ellocartapp.R;
import com.ellocart.ellocartapp.adapter.BannerAdapter;
import com.ellocart.ellocartapp.adapter.LocalCategoryAdapter;
import com.ellocart.ellocartapp.modal.CategoryItem;

import java.util.ArrayList;

public class VH_CategoryLocal extends RecyclerView.ViewHolder {
    public TextView txtCategoriesH1, txtCategoriesH2;

    public RecyclerView rvLocalCategories;
    private LinearLayoutManager layoutManagerCategoryItem;
    private LocalCategoryAdapter localCategoryAdapter;

    public VH_CategoryLocal(@NonNull View itemView) {
        super(itemView);
        txtCategoriesH1 = itemView.findViewById(R.id.txt_categories_h1);
        txtCategoriesH2 = itemView.findViewById(R.id.txt_categories_h2);
        rvLocalCategories = itemView.findViewById(R.id.rv_local_categories);
    }
    public void setCategoryH1(String name) {
        txtCategoriesH1.setText(name);
    }
    public void setCategoryH2(String name) {
        txtCategoriesH2.setText(name);
    }
    public void setCategoryItems(Context context, ArrayList<CategoryItem> categoryItems) {
        layoutManagerCategoryItem = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rvLocalCategories.setLayoutManager(layoutManagerCategoryItem);
        localCategoryAdapter = new LocalCategoryAdapter(context, categoryItems);
        rvLocalCategories.setAdapter(localCategoryAdapter);
    }
}
