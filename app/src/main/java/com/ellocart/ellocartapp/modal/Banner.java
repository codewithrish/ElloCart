package com.ellocart.ellocartapp.modal;

import java.util.ArrayList;

public class Banner {
    private ArrayList<BannerItem> banners;
    private String status, message, type;

    public Banner() {
    }

    public ArrayList<BannerItem> getBanners() {
        return banners;
    }

    public void setBanners(ArrayList<BannerItem> banners) {
        this.banners = banners;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
