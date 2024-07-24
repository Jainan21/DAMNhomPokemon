package com.example.duanmaunhompokemon;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class authoractivity extends AppCompatActivity {

    private TextView txtChangePassword;
    private TextView txtChangeAccount;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        TextView btnWithdraw = findViewById(R.id.tvwithd);
        TextView btnRechar = findViewById(R.id.tvrechar);
        txtChangePassword = findViewById(R.id.change_password);
        txtChangeAccount = findViewById(R.id.change_account);

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
        alertDialog.show();
    }

    private void showRecharForm() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.recharge_form, null);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showChangePasswordDialog() {
        dialog = new Dialog(authoractivity.this);
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

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    private void showDialog() {
        dialog = new Dialog(authoractivity.this);
        dialog.setContentView(R.layout.dialog_update_account);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        EditText etDisplayName = dialog.findViewById(R.id.etDisplayName);
        EditText etEmail = dialog.findViewById(R.id.etEmail);
        Button btnUpdate = dialog.findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String displayName = etDisplayName.getText().toString();
                String email = etEmail.getText().toString();

                TextView txtName = findViewById(R.id.txtname_acc);
                TextView txtEmail = findViewById(R.id.txtemail_acc);
                txtName.setText(displayName);
                txtEmail.setText(email);

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
