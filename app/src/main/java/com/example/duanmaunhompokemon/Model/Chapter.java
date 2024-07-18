package com.example.duanmaunhompokemon.Model;

public class Chapter {
    private Integer id;
    private Integer id_book;
    private Integer chap_number;
    private String titlechap;
    private String content;

    public Chapter(Integer id, Integer id_book, Integer chap_number, String titlechap, String content) {
        this.id = id;
        this.id_book = id_book;
        this.chap_number = chap_number;
        this.titlechap = titlechap;
        this.content = content;
    }

    public Chapter(Integer id_book, Integer chap_number, String titlechap, String content) {
        this.id_book = id_book;
        this.chap_number = chap_number;
        this.titlechap = titlechap;
        this.content = content;
    }

    public Chapter(String content, Integer chap_number, Integer id_book) {
        this.content = content;
        this.chap_number = chap_number;
        this.id_book = id_book;
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

    public Integer getChap_number() {
        return chap_number;
    }

    public void setChap_number(Integer chap_number) {
        this.chap_number = chap_number;
    }

    public String getTitlechap() {
        return titlechap;
    }

    public void setTitlechap(String titlechap) {
        this.titlechap = titlechap;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
