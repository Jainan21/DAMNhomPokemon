package com.example.duanmaunhompokemon;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.Myadapter;
import com.example.duanmaunhompokemon.Model.Rose;

import java.util.ArrayList;
import java.util.List;

public class UserManage extends BaseActivity {
    private RecyclerView recyclerView;
    private Button btthem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.user_manage_main, "Quản lý người dùng");


        btthem = findViewById(R.id.btnThem);
        List<Rose> roseList = new ArrayList<Rose>();
        roseList.add(new Rose("Rose", R.drawable.rose));
        roseList.add(new Rose("Rose", R.drawable.rose));
        roseList.add(new Rose("Rose", R.drawable.rose));
        roseList.add(new Rose("Rose", R.drawable.rose));
        roseList.add(new Rose("Rose", R.drawable.rose));
        roseList.add(new Rose("Rose", R.drawable.rose));
        roseList.add(new Rose("Rose", R.drawable.rose));
        roseList.add(new Rose("Rose", R.drawable.rose));
        roseList.add(new Rose("Rose", R.drawable.rose));
        recyclerView = findViewById(R.id.recyclerview);
        Myadapter myadapter = new Myadapter(roseList);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
    }

}