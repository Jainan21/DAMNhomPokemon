package com.example.duanmaunhompokemon;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.Myadapter;
import com.example.duanmaunhompokemon.Adapter.SearchingAdapter;
import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;

import java.util.ArrayList;
import java.util.List;

public class UserManage extends BaseActivity  {
    private RecyclerView recyclerView;
    dbDAO dao;
    ImageView btnSearch;
    EditText txtName;
    List<Account> roseList;
    Button btnDel;
    Myadapter myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActionBarAndBack(R.layout.user_manage_main, "Quản lý người dùng");

        btnSearch = findViewById(R.id.user_btnSearch);
        txtName = findViewById(R.id.user_txtUsername);
        btnDel = findViewById(R.id.user_Delbtn);
        recyclerView = findViewById(R.id.recyclerview);

        dao = new dbDAO(UserManage.this);
        loadAccount();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                roseList = new ArrayList<>();
                roseList = dao.searchUserbyName(txtName.getText().toString());
                if (roseList.isEmpty()) {
                    Toast.makeText(UserManage.this, "Không có người dùng cần tìm", Toast.LENGTH_SHORT).show();
                } else {
                    Myadapter myadapter = new Myadapter(roseList);
                    recyclerView.setAdapter(myadapter);
                    recyclerView.setLayoutManager(new GridLayoutManager(UserManage.this,1));
                }
            }
        });

    }

    public void loadAccount(){
        roseList = dao.getAllUser();

        myadapter = new Myadapter(roseList);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));

        myadapter.setOnItemClickListener(new Myadapter.OnItemClickListener() {
            @Override
            public void onDeleteClick(int position) {
                Account acc = roseList.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(UserManage.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có chắc chắn muốn xoá không ?");

                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {dialog.dismiss();
                    }
                });

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        boolean check = dao.deleteAccountById(acc.getId());
                        if (check){
                            loadAccount();
                            Toast.makeText(UserManage.this, "Xoá thành công", Toast.LENGTH_SHORT).show();
                        }else Toast.makeText(UserManage.this, "Xoá thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

}