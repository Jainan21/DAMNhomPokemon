package com.example.duanmaunhompokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.ListAuthorAdapter;
import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;

import java.util.ArrayList;

public class Listauthor extends BaseActivity {
    private RecyclerView recyclerView;
    private ListAuthorAdapter LAdapter;
    private RecyclerView.LayoutManager layoutManager;
    TextView txtAuthorName1, txtAuthorName2, txtAuthorName3;
    ImageView imgAuthor1, imgAuthor2, imgAuthor3;
    dbDAO dao;
    ArrayList<Account> accountList;
    ArrayList<Account> list3;
    ArrayList<Account> listA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listauthor);

        txtAuthorName1 = findViewById(R.id.txtAuthorName1);
        txtAuthorName2 = findViewById(R.id.txtAuthorName2);
        txtAuthorName3 = findViewById(R.id.txtAuthorName3);
        recyclerView = findViewById(R.id.recyclerView_listauthor);
        layoutManager = new LinearLayoutManager(this);

        imgAuthor1 = findViewById(R.id.imgAuthor1);
        imgAuthor2 = findViewById(R.id.imgAuthor2);
        imgAuthor3 = findViewById(R.id.imgAuthor3);

        dao = new dbDAO(this);
        accountList = new ArrayList<>();
        list3 = new ArrayList<>();
        listA = new ArrayList<>();

        loadAuthor();

        imgAuthor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list3.size() > 0) {
                    Intent intent = new Intent(Listauthor.this, product.class);
                    intent.putExtra("id_author", list3.get(0).getId());
                    startActivity(intent);
                }
            }
        });

        imgAuthor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list3.size() > 1) {
                    Intent intent = new Intent(Listauthor.this, product.class);
                    intent.putExtra("id_author", list3.get(1).getId());
                    startActivity(intent);
                }
            }
        });

        imgAuthor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list3.size() > 2) {
                    Intent intent = new Intent(Listauthor.this, product.class);
                    intent.putExtra("id_author", list3.get(2).getId());
                    startActivity(intent);
                }
            }
        });
    }

    public void loadTop3(ArrayList<Account> accounts) {
        if (accounts.size() > 0) {
            txtAuthorName1.setText(accounts.get(0).getUser());
        }
        if (accounts.size() > 1) {
            txtAuthorName2.setText(accounts.get(1).getUser());
        }
        if (accounts.size() > 2) {
            txtAuthorName3.setText(accounts.get(2).getUser());
        }
    }

    public void loadAuthor() {
        accountList = dao.getAuthorsSortedByBooksPurchased();

        for (int i = 0; i < accountList.size(); i++) {
            if (i >= 0 && i <= 2) {
                list3.add(accountList.get(i));
            } else {
                listA.add(accountList.get(i));
            }
        }

        loadTop3(list3);

        recyclerView.setLayoutManager(layoutManager);
        LAdapter = new ListAuthorAdapter(Listauthor.this, listA);
        recyclerView.setAdapter(LAdapter);

        LAdapter.setOnItemClickListener(new ListAuthorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(Listauthor.this, product.class);
                intent.putExtra("id_author", listA.get(position).getId());
                startActivity(intent);
            }
        });
    }
}