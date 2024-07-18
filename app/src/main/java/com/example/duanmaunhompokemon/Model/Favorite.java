package com.example.duanmaunhompokemon.Model;

public class Favorite {
    private Integer id;
    private Integer id_book;
    private Integer id_acc;

    public Favorite(Integer id_book, Integer id_acc) {
        this.id_book = id_book;
        this.id_acc = id_acc;
    }

    public Favorite(Integer id, Integer id_book, Integer id_acc) {
        this.id = id;
        this.id_book = id_book;
        this.id_acc = id_acc;
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
}
