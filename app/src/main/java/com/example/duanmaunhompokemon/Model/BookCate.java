package com.example.duanmaunhompokemon.Model;

public class BookCate {
    private Integer id;
    private Integer id_book;
    private Integer id_cate;

    public BookCate(Integer id, Integer id_book, Integer id_cate) {
        this.id = id;
        this.id_book = id_book;
        this.id_cate = id_cate;
    }

    public BookCate(Integer id_book, Integer id_cate) {
        this.id_book = id_book;
        this.id_cate = id_cate;
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

    public Integer getId_cate() {
        return id_cate;
    }

    public void setId_cate(Integer id_cate) {
        this.id_cate = id_cate;
    }
}
