package com.example.duanmaunhompokemon;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;

public class useractivity extends Fragment {
    private TextView txtChangePassword;
    private TextView txtChangeAccount;
    private Dialog dialog;
    private Object useractivity;
    private DrawerLayout drawerLayout;
    public useractivity() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_user, container, false);

        TextView btnWithdraw = v.findViewById(R.id.tvwithd);
        TextView btnRechar = v.findViewById(R.id.tvrechar);
        txtChangePassword = v.findViewById(R.id.change_password);
        txtChangeAccount = v.findViewById(R.id.change_account);



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
        return v;
    }

    private void showWithdrawForm() {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context) useractivity);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.withdraw_form, null);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showRecharForm() {
        AlertDialog.Builder builder = new AlertDialog.Builder((Context) useractivity);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.recharge_form, null);
        builder.setView(dialogView);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void showChangePasswordDialog() {
        dialog = new Dialog((Context) useractivity);
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
        dialog = new Dialog((Context) useractivity);
        dialog.setContentView(R.layout.dialog_update_account);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);


        EditText etDisplayName = dialog.findViewById(R.id.etDisplayName);
        EditText etEmail = dialog.findViewById(R.id.etEmail);
        Button btnUpdate = dialog.findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the update logic here
                String displayName = etDisplayName.getText().toString();
                String email = etEmail.getText().toString();
                // Update the display with new values (you can add your own logic here)
                TextView txtName = dialog.findViewById(R.id.txtname_acc);
                TextView txtEmail = dialog.findViewById(R.id.txtemail_acc);
                txtName.setText(displayName);
                txtEmail.setText(email);

                dialog.dismiss();
            }
        });

        dialog.show();
    }
    public void openDrawer(View view) {
        if (drawerLayout != null) {
            drawerLayout.openDrawer(view.findViewById(R.id.drawer_view));
        }
    }
}

