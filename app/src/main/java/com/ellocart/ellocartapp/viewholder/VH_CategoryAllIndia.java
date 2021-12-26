package com.ellocart.ellocartapp.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ellocart.ellocartapp.R;
import com.ellocart.ellocartapp.adapter.AllIndiaCategoryAdapter;
import com.ellocart.ellocartapp.adapter.LocalCategoryAdapter;
import com.ellocart.ellocartapp.modal.CategoryItem;

import java.util.ArrayList;

public class VH_CategoryAllIndia extends RecyclerView.ViewHolder {
    public TextView txtCategoriesH1, txtCategoriesH2;

    public RecyclerView rvAllIndiaCategories;
    private LinearLayoutManager layoutManagerCategoryItem;
    private AllIndiaCategoryAdapter allIndiaCategoryAdapter;
    public VH_CategoryAllIndia(@NonNull View itemView) {
        super(itemView);
        txtCategoriesH1 = itemView.findViewById(R.id.txt_categories_h1);
        txtCategoriesH2 = itemView.findViewById(R.id.txt_categories_h2);
        rvAllIndiaCategories = itemView.findViewById(R.id.rv_all_india_categories);
    }
    public void setCategoryH1(String name) {
        txtCategoriesH1.setText(name);
    }
    public void setCategoryH2(String name) {
        txtCategoriesH2.setText(name);
    }
    public void setCategoryItems(Context context, ArrayList<CategoryItem> categoryItems) {
        //txtCategoryName.setText(name);
        layoutManagerCategoryItem = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        rvAllIndiaCategories.setLayoutManager(layoutManagerCategoryItem);
        allIndiaCategoryAdapter = new AllIndiaCategoryAdapter(context, categoryItems);
        rvAllIndiaCategories.setAdapter(allIndiaCategoryAdapter);
    }
}
