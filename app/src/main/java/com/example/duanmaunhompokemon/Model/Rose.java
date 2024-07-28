package com.example.duanmaunhompokemon.Model;

import android.widget.Button;

public class Rose {
    private String name;
    private int imageID;
    private Button btXoa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public Button getBtXoa() {
        return btXoa;
    }

    public void setBtXoa(Button btXoa) {
        this.btXoa = btXoa;
    }

    public Rose(String name, int imageID) {
        this.name = name;
        this.imageID = imageID;
        this.btXoa = btXoa;
    }
}
