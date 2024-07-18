package com.example.duanmaunhompokemon.Model;

public class Account {
    private Integer id;
    private String user;
    private String pass;
    private String email;
    private Integer id_role;
    private Double budget;

    public Account(Integer id, String user, String pass, String email, Integer id_role, Double budget) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.id_role = id_role;
        this.budget = budget;
    }

    public Account(String user, String pass, String email, Integer id_role, Double budget) {
        this.user = user;
        this.pass = pass;
        this.email = email;
        this.id_role = id_role;
        this.budget = budget;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
}
