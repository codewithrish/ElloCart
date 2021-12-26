package com.ellocart.ellocartapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.ellocart.ellocartapp.R;
import com.ellocart.ellocartapp.modal.CategoryItem;

import java.util.List;

public class LocalCategoryAdapter extends RecyclerView.Adapter<LocalCategoryAdapter.ViewHolder> {

    private final Context context;
    private final List<CategoryItem> categoryItems;

    public LocalCategoryAdapter(Context context, List<CategoryItem> categoryItems) {
        this.context = context;
        this.categoryItems = categoryItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_category_local_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.loadImage(categoryItems.get(position).getCategory_image());
        holder.txtCategoryName.setText(categoryItems.get(position).getCategory_name());
    }

    @Override
    public int getItemCount() {
        return categoryItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCategoryImage;
        TextView txtCategoryName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCategoryImage = itemView.findViewById(R.id.img_category_image);
            txtCategoryName = itemView.findViewById(R.id.txt_category_name);
        }
        public void loadImage(String url) {
            Glide.with(context).load(url).centerCrop().into(imgCategoryImage);
        }
    }
}
