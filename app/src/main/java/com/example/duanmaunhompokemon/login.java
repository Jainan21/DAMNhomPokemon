package com.example.duanmaunhompokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;

import java.util.ArrayList;

public class login extends AppCompatActivity {

    EditText edtUsernameLogin, edtPasswordLogin;
    Button btnLogin;
    TextView txtRregister;
    dbDAO db = new dbDAO(login.this);
    ArrayList<Account> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

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
                    Toast.makeText(login.this, "You don't have an account !!!", Toast.LENGTH_SHORT).show();
                }else {
                    boolean check = false;
                    for (int i=0; i<list.size(); i++){
                        if(u.equalsIgnoreCase(list.get(i).getUser()) && p.equalsIgnoreCase(list.get(i).getPass())){
                            if (list.get(i).getId_role().equals(2) || list.get(i).getId_role().equals(3)){
                                Account a = list.get(i);
                                check = true;
                                Intent intent = new Intent(login.this, BookView.class);
                                intent.putExtra("login", a);
                                startActivity(intent);
                                finish();
                                break;
                            }
                        }
                    }
                    if(!check){
                        Toast.makeText(login.this, "Login failed !!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}