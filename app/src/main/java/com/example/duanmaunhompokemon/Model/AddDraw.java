package com.example.duanmaunhompokemon.Model;

public class AddDraw {
    private Integer id;
    private Integer id_acc;
    private String date_ad;
    private String price_ad;
    private String type;

    public AddDraw(Integer id, Integer id_acc, String date_ad, String price_ad, String type) {
        this.id = id;
        this.id_acc = id_acc;
        this.date_ad = date_ad;
        this.price_ad = price_ad;
        this.type = type;
    }

    public AddDraw(Integer id_acc, String date_ad, String price_ad, String type) {
        this.id_acc = id_acc;
        this.date_ad = date_ad;
        this.price_ad = price_ad;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_acc() {
        return id_acc;
    }

    public void setId_acc(Integer id_acc) {
        this.id_acc = id_acc;
    }

    public String getDate_ad() {
        return date_ad;
    }

    public void setDate_ad(String date_ad) {
        this.date_ad = date_ad;
    }

    public String getPrice_ad() {
        return price_ad;
    }

    public void setPrice_ad(String price_ad) {
        this.price_ad = price_ad;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
