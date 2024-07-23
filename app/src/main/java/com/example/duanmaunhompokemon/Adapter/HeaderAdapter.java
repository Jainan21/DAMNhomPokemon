package com.example.duanmaunhompokemon.Adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duanmaunhompokemon.BookView;
import com.example.duanmaunhompokemon.R;
import com.example.duanmaunhompokemon.SearchingView;
import com.example.duanmaunhompokemon.user;

public class HeaderAdapter  {

    public static void setupHeader(final Activity activity){
        ImageView home, account, search, menu;
        home = activity.findViewById(R.id.iconHome);
        account = activity.findViewById(R.id.iconAccount);
        search = activity.findViewById(R.id.iconSearch);
        menu = activity.findViewById(R.id.iconMenu);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, BookView.class));
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, user.class));
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, SearchingView.class));
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, BookView.class));
            }
        });

    }

    public static void setupHeader2(final Activity activity, String title){
        Button btnBeforeHd2, btnMenuHd2;
        TextView txtTitleHd2;

        btnBeforeHd2 = activity.findViewById(R.id.btnBeforeHd2);
        btnMenuHd2 = activity.findViewById(R.id.btnMenuHd2);
        txtTitleHd2 = activity.findViewById(R.id.txtTitleHd2);

        txtTitleHd2.setText(title);

        btnBeforeHd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, BookView.class));
            }
        });

        btnMenuHd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, BookView.class));
            }
        });

    }

}
