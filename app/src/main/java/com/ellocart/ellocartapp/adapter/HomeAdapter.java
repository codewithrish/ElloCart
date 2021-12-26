package com.ellocart.ellocartapp.adapter;


import static com.ellocart.ellocartapp.util.AppConstants.ALL_INDIA;
import static com.ellocart.ellocartapp.util.AppConstants.ALL_INDIA_C;
import static com.ellocart.ellocartapp.util.AppConstants.HOME;
import static com.ellocart.ellocartapp.util.AppConstants.LOCAL;
import static com.ellocart.ellocartapp.util.AppConstants.PROFESSIONAL;
import static com.ellocart.ellocartapp.util.AppConstants.STORE;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ellocart.ellocartapp.R;
import com.ellocart.ellocartapp.modal.Banner;
import com.ellocart.ellocartapp.modal.Category;
import com.ellocart.ellocartapp.viewholder.VH_BannerAllIndia;
import com.ellocart.ellocartapp.viewholder.VH_BannerHome;
import com.ellocart.ellocartapp.viewholder.VH_CategoryAllIndia;
import com.ellocart.ellocartapp.viewholder.VH_CategoryLocal;
import com.ellocart.ellocartapp.viewholder.VH_BannerProfessional;
import com.ellocart.ellocartapp.viewholder.VH_CategoryStore;
import com.ellocart.ellocartapp.viewholder.VH_Title;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private final List<Object> homeItems;

    public HomeAdapter(Context context, List<Object> homeItems) {
        this.context = context;
        this.homeItems = homeItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recylerview_list, parent, false);
        switch (viewType) {
            case 0:
                return new VH_BannerAllIndia(view);
            case 1:
                return new VH_BannerHome(view);
            case 2:
                return new VH_BannerProfessional(view);
            case 3:
                view = LayoutInflater.from(context).inflate(R.layout.list_item_category_all_india, parent, false);
                return new VH_CategoryAllIndia(view);
            case 4:
                view = LayoutInflater.from(context).inflate(R.layout.list_item_category_local, parent, false);
                return new VH_CategoryLocal(view);
            case 5:
                view = LayoutInflater.from(context).inflate(R.layout.list_item_category_store, parent, false);
                return new VH_CategoryStore(view);
            default:
                Log.d("TAG", "onCreateViewHolder: " + "INTO Defalt");
                return new VH_Title(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case 0:
                VH_BannerAllIndia vh_bannerAllIndia = (VH_BannerAllIndia)holder;
                Banner bannerAllIndia = (Banner) homeItems.get(position);
                vh_bannerAllIndia.loadBanners(bannerAllIndia.getBanners(), context);
                break;
            case 1:
                VH_BannerHome vh_bannerHome = (VH_BannerHome)holder;
                Banner bannerHome = (Banner) homeItems.get(position);
                vh_bannerHome.loadBanners(bannerHome.getBanners(), context);
                break;
            case 2:
                VH_BannerProfessional vh_bannerProfessional = (VH_BannerProfessional)holder;
                Banner bannerProfessional = (Banner) homeItems.get(position);
                vh_bannerProfessional.loadBanners(bannerProfessional.getBanners(), context);
                break;
            case 3:
                VH_CategoryAllIndia vh_categoryAllIndia = (VH_CategoryAllIndia)holder;
                Category categoryAllIndia = (Category) homeItems.get(position);
                vh_categoryAllIndia.setCategoryH1(categoryAllIndia.getCategoriesH1());
                vh_categoryAllIndia.setCategoryH2(categoryAllIndia.getCategoriesH2());
                vh_categoryAllIndia.setCategoryItems(context, categoryAllIndia.getCategories());
                break;
            case 4:
                VH_CategoryLocal vh_categoryLocal = (VH_CategoryLocal)holder;
                Category categoryLocal = (Category) homeItems.get(position);
                vh_categoryLocal.setCategoryH1(categoryLocal.getCategoriesH1());
                vh_categoryLocal.setCategoryH2(categoryLocal.getCategoriesH2());
                vh_categoryLocal.setCategoryItems(context, categoryLocal.getCategories());
                break;
            case 5:
                VH_CategoryStore vh_categoryStore = (VH_CategoryStore)holder;
                Category categoryStore = (Category) homeItems.get(position);
                vh_categoryStore.loadStores(categoryStore.getCategories(), context);
                break;
            default:
                VH_Title vh_title = (VH_Title)holder;
                break;

        }
    }


    @Override
    public int getItemViewType(int position) {
        Object homeItem = homeItems.get(position);
        if (homeItem instanceof Banner) {
            Banner banner = (Banner) homeItem;
            if (banner.getType().equals(ALL_INDIA)) {
                return 0;
            } else if (banner.getType().equals(HOME)) {
                return 1;
            } else if (banner.getType().equals(PROFESSIONAL)) {
                return 2;
            }
        } else if (homeItem instanceof Category) {
            Category category = (Category) homeItem;
            if (category.getType().equals(ALL_INDIA_C)) {
                return 3;
            } else if (category.getType().equals(LOCAL)) {
                return 4;
            } else if (category.getType().equals(STORE)) {
                return 5;
            }
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return homeItems.size();
    }

}
