package com.example.duanmaunhompokemon;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;

import java.util.ArrayList;

public class login extends AppCompatActivity {

    EditText edtUsernameLogin, edtPasswordLogin;
    Button btnLogin;
    TextView txtRregister;
    private Object login;
    dbDAO db;
    ArrayList<Account> list = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        db = new dbDAO(this);


        edtUsernameLogin = findViewById(R.id.edtUsernameLogin);
        edtPasswordLogin = findViewById(R.id.edtPasswordLogin);
        btnLogin = findViewById(R.id.btnLogin);
        txtRregister = findViewById(R.id.txtRregister);

        list = db.getAllAccount();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u = edtUsernameLogin.getText().toString();
                String p = edtPasswordLogin.getText().toString();

                if(u.isEmpty() || p.isEmpty()){
                    Toast.makeText(login.this, "You didn't enter enough information !!!", Toast.LENGTH_SHORT).show();
                }else if(list.isEmpty()){
                    Toast.makeText(login.this
                            , "You don't have an account !!!", Toast.LENGTH_SHORT).show();
                }else {
                    boolean check = false;
                    for (int i=0; i<list.size(); i++){
                        if(u.equalsIgnoreCase(list.get(i).getUser()) && p.equalsIgnoreCase(list.get(i).getPass())) {
                            Account a = list.get(i);
                            check = true;

                            SharedPreferences sharedPreferences = getSharedPreferences("user", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putInt("user_id", a.getId());
                            editor.apply();

                            Intent intent;
                            if (a.getId_role() == 2) {
                                intent = new Intent(login.this, BookView.class);
                            } else if (a.getId_role() == 3) {
                                intent = new Intent(login.this, authoractivity.class);
                            } else {
                                intent = new Intent(login.this, AdminManage.class);
                            }
                            startActivity(intent);
                            finish();
                            break;
                        }
                    }
                    if(!check){
                        Toast.makeText(login.this, "Login failed !!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        txtRregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =  new Intent(getContext(), RegisterView.class);
                startActivity(i);
                finish();
            }
        });
    }
}