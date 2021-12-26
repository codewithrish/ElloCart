package com.ellocart.ellocartapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ellocart.ellocartapp.R;
import com.ellocart.ellocartapp.modal.CategoryItem;
import com.ellocart.ellocartapp.modal.Store;

import java.util.ArrayList;
import java.util.List;

public class StoreCategoryAdapter extends RecyclerView.Adapter<StoreCategoryAdapter.ViewHolder> {

    private Context context;
    private List<CategoryItem> categoryItems;

    public StoreCategoryAdapter(Context context, List<CategoryItem> categoryItems) {
        this.context = context;
        this.categoryItems = categoryItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_category_store_item, parent, false);
        return new StoreCategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtCategoryName.setText(categoryItems.get(position).getCategory_name());
        holder.loadStores(categoryItems.get(position).getCategory_stores());
    }

    @Override
    public int getItemCount() {
        return categoryItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtCategoryName;
        RecyclerView rvStores;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCategoryName = itemView.findViewById(R.id.txt_category_name);
            rvStores = itemView.findViewById(R.id.rv_stores);
        }

        public void loadStores(ArrayList<Store> categoryStores) {
            LinearLayoutManager layoutManagerStores = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            rvStores.setLayoutManager(layoutManagerStores);
            StoreAdapter sellerAdapter = new StoreAdapter(context, categoryStores);
            rvStores.setAdapter(sellerAdapter);
        }
    }
}
