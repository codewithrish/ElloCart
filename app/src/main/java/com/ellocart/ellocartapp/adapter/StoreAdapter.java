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
import com.ellocart.ellocartapp.modal.Store;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {
    private Context context;
    private List<Store> stores;

    public StoreAdapter(Context context, List<Store> stores) {
        this.context = context;
        this.stores = stores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_category_store_item_item, parent, false);
        return new StoreAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtStoreName.setText(stores.get(position).getSeller_store_name());
        holder.loadStoreImage(stores.get(position).getSeller_store_image());
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgStoreImage;
        TextView txtStoreName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgStoreImage = itemView.findViewById(R.id.img_store_image);
            txtStoreName = itemView.findViewById(R.id.txt_store_name);
        }

        public void loadStoreImage(String url) {
            Glide.with(context).load(url).into(imgStoreImage);
        }
    }
}
