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

public class login extends Fragment {

    EditText edtUsernameLogin, edtPasswordLogin;
    Button btnLogin;
    TextView txtRregister;
    private Object login;
    dbDAO db = new dbDAO((Context) login);
    ArrayList<Account> list = new ArrayList<>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.login, container, false);

        edtUsernameLogin = v.findViewById(R.id.edtUsernameLogin);
        edtPasswordLogin = v.findViewById(R.id.edtPasswordLogin);
        btnLogin = v.findViewById(R.id.btnLogin);
        txtRregister = v.findViewById(R.id.txtRregister);

//        list = db.getAllAccount();

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String u = edtUsernameLogin.getText().toString();
//                String p = edtPasswordLogin.getText().toString();
//
//                if(u.isEmpty() || p.isEmpty()){
//                    Toast.makeText((Context) login, "You didn't enter enough information !!!", Toast.LENGTH_SHORT).show();
//                }else if(list.isEmpty()){
//                    Toast.makeText((Context) login, "You don't have an account !!!", Toast.LENGTH_SHORT).show();
//                }else {
//                    boolean check = false;
//                    for (int i=0; i<list.size(); i++){
//                        if(u.equalsIgnoreCase(list.get(i).getUser()) && p.equalsIgnoreCase(list.get(i).getPass())){
//                            if (list.get(i).getId_role() == 2){
//                                Account a = list.get(i);
//                                check = true;
//
//                                SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
//                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                editor.putInt("user_id", a.getId());
//                                editor.apply();
//
//                                Intent intent = new Intent((Context) login, BookView.class);
//                                startActivity(intent);
//                                finish();
//                                break;
//                            }else if (list.get(i).getId_role() == 3){
//                                Account a = list.get(i);
//                                check = true;
//
//                                SharedPreferences sharedPreferences = getSharedPreferences("author", MODE_PRIVATE);
//                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                editor.putInt("author_id", a.getId());
//                                editor.apply();
//
//                                Intent intent = new Intent((Context) login, authoractivity.class);
//                                startActivity(intent);
//                                finish();
//                                break;
//                            }else {
//                                Account a = list.get(i);
//                                check = true;
//
//                                SharedPreferences sharedPreferences = getSharedPreferences("admin", MODE_PRIVATE);
//                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                editor.putInt("admin_id", a.getId());
//                                editor.apply();
//
//                                Intent intent = new Intent((Context) login, AdminManage.class);
//                                startActivity(intent);
//                                finish();
//                                break;
//                            }
//                        }
//                    }
//                    if(!check){
//                        Toast.makeText((Context) login, "Login failed !!!", Toast.LENGTH_SHORT).show();
//                    }
//                }
//            }
//        });

//        txtRregister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i =  new Intent((Context) login, RegisterView.class);
//                startActivity(i);
//                finish();
//            }
//        });
        return v;
    }
}