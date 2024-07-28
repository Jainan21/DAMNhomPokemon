package com.example.duanmaunhompokemon;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.Adapter.TradeAdapter;
import com.example.duanmaunhompokemon.DAO.dbDAO;
import com.example.duanmaunhompokemon.Model.Account;
import com.example.duanmaunhompokemon.Model.AddDraw;
import com.example.duanmaunhompokemon.Model.Trade;

import java.util.ArrayList;


public class useractivity extends AppCompatActivity {
    private TextView txtChangePassword, txtname_acc, txtemail_acc, txtBudget_acc;



public class useractivity extends BaseActivity {
    private TextView txtChangePassword;

    private TextView txtChangeAccount;
    RecyclerView lvTrade;
    private Dialog dialog;
    private DrawerLayout drawerLayout;
    private TextView txtname_acc, txtemail_acc, txtBudget_acc;
    Integer user_id;
    ArrayList<Trade> listTrade;
    dbDAO dao = new dbDAO(useractivity.this);
    Account account;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user);
        setupActionBarAndBack(R.layout.activity_user, "Người dùng");


        TextView btnWithdraw = findViewById(R.id.tvwithd);
        TextView btnRechar = findViewById(R.id.tvrechar);
        txtChangePassword = findViewById(R.id.change_password);
        txtChangeAccount = findViewById(R.id.change_account);
        drawerLayout = findViewById(R.id.drawer_layout);
        txtname_acc = findViewById(R.id.txtname_acc);
        txtemail_acc = findViewById(R.id.txtemail_acc);
        txtBudget_acc = findViewById(R.id.txtBudget_acc);
        lvTrade = findViewById(R.id.lvTrade);

        getUserID();
        loadAccount();

        listTrade = dao.getTradesByUserId(user_id);
        TradeAdapter tradeAdapter = new TradeAdapter(useractivity.this, listTrade);
        lvTrade.setAdapter(tradeAdapter);

        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWithdrawForm();
            }
        });


        btnRechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRecharForm();
            }
        });

        txtChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChangePasswordDialog();
            }
        });

        txtChangeAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }

    private void showWithdrawForm() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
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
                    Toast.makeText(useractivity.this, "Không đủ thông tin !!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double withdraw_amount;
                try {
                    withdraw_amount = Double.parseDouble(withdraw_amount_str);
                } catch (NumberFormatException e) {
                    Toast.makeText(useractivity.this, "Số tiền không hợp lệ !!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (withdraw_amount > account.getBudget()) {
                    Toast.makeText(useractivity.this, "Số dư không đủ !!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                dao.subtractFromBudget(user_id, withdraw_amount);
                dao.insertAddDraw(new AddDraw(user_id, "27/07/2024", withdraw_amount_str, "draw"));
                loadAccount();
                Toast.makeText(useractivity.this, "Rút tiền thành công!", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });

        alertDialog.show();
    }

    private void showRecharForm() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.recharge_form, null);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();

        EditText et_account_number = dialogView.findViewById(R.id.et_account_number);
        EditText et_account_name = dialogView.findViewById(R.id.et_account_name);
        EditText et_withdraw_amount = dialogView.findViewById(R.id.et_withdraw_amount);
        Button btn_withdraw = dialogView.findViewById(R.id.btn_withdraw);

        btn_withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account_number = et_account_number.getText().toString();
                String account_name = et_account_name.getText().toString();
                String withdraw_amount = et_withdraw_amount.getText().toString();

                if (account_number.isEmpty() || account_name.isEmpty() || withdraw_amount.isEmpty()) {
                    Toast.makeText(useractivity.this, "Không đủ thông tin !!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                double withdraw_amount_d;
                try {
                    withdraw_amount_d = Double.parseDouble(withdraw_amount);
                } catch (NumberFormatException e) {
                    Toast.makeText(useractivity.this, "Số tiền không hợp lệ !!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                dao.addToBudget(user_id, withdraw_amount_d);
                dao.insertAddDraw(new AddDraw(user_id, "27/07/2024", withdraw_amount, "add"));
                loadAccount();
                Toast.makeText(useractivity.this, "Nạp tiền thành công!", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

    private void showChangePasswordDialog() {
        dialog = new Dialog(useractivity.this);
        dialog.setContentView(R.layout.dialog_change_password);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);


        EditText etOldPassword = dialog.findViewById(R.id.etOldPassword);
        EditText etNewPassword = dialog.findViewById(R.id.etNewPassword);
        EditText etConfirmPassword = dialog.findViewById(R.id.etConfirmPassword);
        Button btnChangePassword = dialog.findViewById(R.id.btnChangePassword);

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String oldPassword = etOldPassword.getText().toString();
                String newPassword = etNewPassword.getText().toString();
                String confirmPassword = etConfirmPassword.getText().toString();

                if (oldPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(useractivity.this, "Không đủ thông tin !!!", Toast.LENGTH_SHORT).show();
                } else if (!oldPassword.equalsIgnoreCase(account.getPass()) || !newPassword.equalsIgnoreCase(confirmPassword)) {
                    Toast.makeText(useractivity.this, "Mật không khớp !!!", Toast.LENGTH_SHORT).show();
                } else {
                    dao.updatePassword(user_id, newPassword);
                    loadAccount();
                    Toast.makeText(useractivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();

                    dialog.dismiss();
                }
            }
        });

        dialog.show();
    }

    private void showDialog() {
        dialog = new Dialog(useractivity.this);
        dialog.setContentView(R.layout.dialog_update_account);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);


        EditText etDisplayName = dialog.findViewById(R.id.etDisplayName);
        EditText etEmail = dialog.findViewById(R.id.etEmail);
        Button btnUpdate = dialog.findViewById(R.id.btnUpdate);

        etDisplayName.setText(account.getUser());
        etEmail.setText(account.getEmail());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String displayName = etDisplayName.getText().toString();
                String email = etEmail.getText().toString();

                boolean check = dao.updateAccount(user_id, displayName, email);

                if (check) {
                    Toast.makeText(useractivity.this, "Chỉnh sửa thành công", Toast.LENGTH_SHORT).show();
                    loadAccount();
                } else {
                    Toast.makeText(useractivity.this, "Chỉnh sửa thất bại !!!", Toast.LENGTH_SHORT).show();
                }

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void openDrawer(View view) {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(findViewById(R.id.drawer_view));
        }
    }

    public void getUserID() {
        SharedPreferences sharedPreferences = getSharedPreferences("user", MODE_PRIVATE);
        Integer userId = sharedPreferences.getInt("user_id", -1);
        if (userId != -1) {
            user_id = userId;
        }
    }

    public void loadAccount() {
        account = dao.getAccountById(user_id);
        txtname_acc.setText(account.getUser());
        txtemail_acc.setText(account.getEmail());
        txtBudget_acc.setText(String.valueOf(account.getBudget()) + "00 VND");


    }
    public boolean onSupportNavigateUp () {
        // Handle the toolbar back button click event
        Intent intent = new Intent(this, BookView.class);
        startActivity(intent);
        finish();
        return true;

    }
}

