package com.example.duanmaunhompokemon.Model;

public class Trade {
    private Integer id;
    private Integer id_book;
    private Integer id_acc;
    private Integer price_trade;
    private String date_trade;
    private Double vat;

    public Trade(Integer id, Integer id_book, Integer id_acc, Integer price_trade, String date_trade, Double vat) {
        this.id = id;
        this.id_book = id_book;
        this.id_acc = id_acc;
        this.price_trade = price_trade;
        this.date_trade = date_trade;
        this.vat = vat;
    }

    public Trade(Integer id_book, Integer id_acc, Integer price_trade, String date_trade, Double vat) {
        this.id_book = id_book;
        this.id_acc = id_acc;
        this.price_trade = price_trade;
        this.date_trade = date_trade;
        this.vat = vat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_book() {
        return id_book;
    }

    public void setId_book(Integer id_book) {
        this.id_book = id_book;
    }

    public Integer getId_acc() {
        return id_acc;
    }

    public void setId_acc(Integer id_acc) {
        this.id_acc = id_acc;
    }

    public Integer getPrice_trade() {
        return price_trade;
    }

    public void setPrice_trade(Integer price_trade) {
        this.price_trade = price_trade;
    }

    public String getDate_trade() {
        return date_trade;
    }

    public void setDate_trade(String date_trade) {
        this.date_trade = date_trade;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }
}
