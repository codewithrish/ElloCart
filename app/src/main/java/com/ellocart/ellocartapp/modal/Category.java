package com.ellocart.ellocartapp.modal;

import java.util.ArrayList;

public class Category {
    private ArrayList<CategoryItem> categories;
    private String status, categoriesClr, categoriesH1, categoriesH2, type;

    public Category() {
    }

    public ArrayList<CategoryItem> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategoryItem> categories) {
        this.categories = categories;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoriesClr() {
        return categoriesClr;
    }

    public void setCategoriesClr(String categoriesClr) {
        this.categoriesClr = categoriesClr;
    }

    public String getCategoriesH1() {
        return categoriesH1;
    }

    public void setCategoriesH1(String categoriesH1) {
        this.categoriesH1 = categoriesH1;
    }

    public String getCategoriesH2() {
        return categoriesH2;
    }

    public void setCategoriesH2(String categoriesH2) {
        this.categoriesH2 = categoriesH2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
