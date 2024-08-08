package com.example.duanmaunhompokemon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.AddDraw;

public class AdminManage extends BaseActivity {
    Button btNguoiDung, btAuthor, btTheLoai, btMoney;
    ImageView btLogout;
    Integer user_id;
    Account account;
    dbDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_manage);

        btNguoiDung = findViewById(R.id.btNguoiDung);
        btAuthor = findViewById(R.id.btAuthor);
        btTheLoai = findViewById(R.id.btTheLoai);
        btMoney = findViewById(R.id.btMoney);
        btLogout =  findViewById(R.id.btnLogout);

        getUserID();
        dao = new dbDAO(AdminManage.this);
        loadAccount();

        btNguoiDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminManage.this, UserManage.class));
            }
        });

        btAuthor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminManage.this, CategoryView.class));
            }
        });

        btMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminManage.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.withdraw_form, null);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();

                EditText et_account_number = dialogView.findViewById(R.id.et_account_number);
                EditText et_account_name = dialogView.findViewById(R.id.et_account_name);
                EditText et_withdraw_amount = dialogView.findViewById(R.id.et_withdraw_amount);
                Button btn_withdraw = dialogView.findViewById(R.id.btn_withdraw);

                btn_withdraw.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String account_number = et_account_number.getText().toString().trim();
                        String account_name = et_account_name.getText().toString().trim();
                        String withdraw_amount_str = et_withdraw_amount.getText().toString().trim();

                        if (account_number.isEmpty() || account_name.isEmpty() || withdraw_amount_str.isEmpty()) {
                            Toast.makeText(AdminManage.this, "Không đủ thông tin !!!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        double withdraw_amount;
                        try {
                            withdraw_amount = Double.parseDouble(withdraw_amount_str);
                        } catch (NumberFormatException e) {
                            Toast.makeText(AdminManage.this, "Số tiền không hợp lệ !!!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (withdraw_amount > account.getBudget()) {
                            Toast.makeText(AdminManage.this, "Số dư không đủ !!!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        dao.subtractFromBudget(user_id, withdraw_amount);
                        dao.insertAddDraw(new AddDraw(user_id, "27/07/2024", withdraw_amount_str, "draw"));
                        loadAccount();
                        Toast.makeText(AdminManage.this, "Rút tiền thành công!", Toast.LENGTH_SHORT).show();
                        alertDialog.dismiss();
                    }
                });

                alertDialog.show();
            }
        });
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminManage.this, login.class));
            }
        });
    }

    public void getUserID() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        Integer userId = sharedPreferences.getInt("user_id", -1);
        if (userId != -1) {
            user_id = userId;
        }
    }

    public void loadAccount(){
        account = dao.getAccountById(user_id);
        btMoney.setText(account.getBudget() + " VND");
    }

}