package com.example.duanmaunhompokemon.Model;

public class Book {
    private Integer id_book;
    private Integer id_acc;
    private String title;
    private Integer price;
    private String date;
    private String sum;
    private Integer bought;

    public Book(Integer id_book, Integer id_acc, String title, Integer price, String date, String sum, Integer bought) {
        this.id_book = id_book;
        this.id_acc = id_acc;
        this.title = title;
        this.price = price;
        this.date = date;
        this.sum = sum;
        this.bought = bought;
    }

    public Book(Integer id_acc, String title, Integer price, String date, String sum, Integer bought) {
        this.id_acc = id_acc;
        this.title = title;
        this.price = price;
        this.date = date;
        this.sum = sum;
        this.bought = bought;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public Integer getBought() {
        return bought;
    }

    public void setBought(Integer bought) {
        this.bought = bought;
    }
}
