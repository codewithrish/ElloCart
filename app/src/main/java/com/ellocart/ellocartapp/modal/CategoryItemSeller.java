package com.ellocart.ellocartapp.modal;

import java.io.Serializable;
import java.util.ArrayList;

public class CategoryItemSeller implements Serializable {
    private String category_id, category_name, category_image, category_clr, category_clr1;
    private ArrayList<Store>  category_stores;

    public CategoryItemSeller() {
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_image() {
        return category_image;
    }

    public void setCategory_image(String category_image) {
        this.category_image = category_image;
    }

    public String getCategory_clr() {
        return category_clr;
    }

    public void setCategory_clr(String category_clr) {
        this.category_clr = category_clr;
    }

    public String getCategory_clr1() {
        return category_clr1;
    }

    public void setCategory_clr1(String category_clr1) {
        this.category_clr1 = category_clr1;
    }

    public ArrayList<Store> getCategory_stores() {
        return category_stores;
    }

    public void setCategory_stores(ArrayList<Store> category_stores) {
        this.category_stores = category_stores;
    }
}
