package com.example.duanmaunhompokemon.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duanmaunhompokemon.BookView;
import com.example.duanmaunhompokemon.R;
import com.example.duanmaunhompokemon.WelcomeView;
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
                activity.startActivity(new Intent(activity, BookView.class));
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, BookView.class));
            }
        });

    }

}
