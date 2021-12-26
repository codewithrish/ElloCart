package com.ellocart.ellocartapp.modal;

import java.io.Serializable;

public class Store implements Serializable {
    private String seller_id, seller_store_image, seller_store_name, seller_distance, seller_ostatus, seller_minimum_order;

    public Store() {
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_store_image() {
        return seller_store_image;
    }

    public void setSeller_store_image(String seller_store_image) {
        this.seller_store_image = seller_store_image;
    }

    public String getSeller_store_name() {
        return seller_store_name;
    }

    public void setSeller_store_name(String seller_store_name) {
        this.seller_store_name = seller_store_name;
    }

    public String getSeller_distance() {
        return seller_distance;
    }

    public void setSeller_distance(String seller_distance) {
        this.seller_distance = seller_distance;
    }

    public String getSeller_ostatus() {
        return seller_ostatus;
    }

    public void setSeller_ostatus(String seller_ostatus) {
        this.seller_ostatus = seller_ostatus;
    }

    public String getSeller_minimum_order() {
        return seller_minimum_order;
    }

    public void setSeller_minimum_order(String seller_minimum_order) {
        this.seller_minimum_order = seller_minimum_order;
    }
}
