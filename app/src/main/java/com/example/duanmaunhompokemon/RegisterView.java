package com.example.duanmaunhompokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.Role;

import java.util.ArrayList;

public class RegisterView extends AppCompatActivity {

    EditText edUsername, edPassword, edConfirmPassword, edGmail;
    Spinner spList;
    Button btRegister, btBack;
    dbDAO  db = new dbDAO(RegisterView.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_view);


        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        edConfirmPassword = findViewById(R.id.edConfirmPassword);
        edGmail = findViewById(R.id.edGmail);
        spList = findViewById(R.id.spList);
        btRegister = findViewById(R.id.btRegister);
        btBack = findViewById(R.id.btBack);

        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Role(1,"Admin"));
        roles.add(new Role(2,"User"));
        roles.add(new Role(3,"Author"));

        ArrayAdapter<Role> adapter = new ArrayAdapter<>(RegisterView.this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spList.setAdapter(adapter);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String u = edUsername.getText().toString();
                String p = edPassword.getText().toString();
                String cofi = edConfirmPassword.getText().toString();
                String e = edGmail .getText().toString();
                Role selectedRole = (Role) spList.getSelectedItem();

                if(u.isEmpty() || p.isEmpty() || cofi.isEmpty() ||  e.isEmpty()){
                    Toast.makeText(RegisterView.this, "You didn't enter enough information !!!", Toast.LENGTH_SHORT).show();
                }else if(!p.equalsIgnoreCase(cofi)){
                    Toast.makeText(RegisterView.this, "Passwords don't match !!!", Toast.LENGTH_SHORT).show();
                }else {

                    Account acc = new Account(u, p, e, selectedRole.getId(),0.0);
                    boolean check = db.insertAccount(acc);
                    if (check){
                        Intent i =  new Intent(RegisterView.this, login.class);
                        startActivity(i);
                        finish();
                    }else {
                        Toast.makeText(RegisterView.this, "Registration failed !!!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}