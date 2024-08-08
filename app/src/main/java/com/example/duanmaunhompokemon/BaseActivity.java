package com.example.duanmaunhompokemon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public abstract class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This will be overridden in child classes
    }

    protected void setupActionBarAndDrawer(int layoutResID) {
        setContentView(layoutResID);

        ImageView home, search, account;
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.Nav_bar);
        navigationView.setNavigationItemSelectedListener(this);
        home = findViewById(R.id.iconHome);
        search = findViewById(R.id.iconSearch);
        account = findViewById(R.id.iconAccount);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this, BookView.class));
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPushButtonClick();
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BaseActivity.this, useractivity.class));
            }
        });

        ImageView menu = findViewById(R.id.iconMenu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    drawerLayout.closeDrawer(GravityCompat.END);
                } else {
                    drawerLayout.openDrawer(GravityCompat.END);
                }
            }
        });
    }

    public void setupActionBarAndBack(int layoutResID, String title) {
        setContentView(layoutResID);

        Toolbar toolbar = findViewById(R.id.header2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.Nav_bar);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView menu = findViewById(R.id.menubtn);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    drawerLayout.closeDrawer(GravityCompat.END);
                } else {
                    drawerLayout.openDrawer(GravityCompat.END);
                }
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_home) {
            startActivity(new Intent(this, BookView.class));
        }
        else if (id == R.id.item_account) {
            startActivity(new Intent(this, useractivity.class));
        } else if (id == R.id.item_search) {
            startActivity(new Intent(this, SearchingView.class));
        } else if (id == R.id.item_bookshelf) {
            startActivity(new Intent(this, BookCaseView.class));
        } else if (id == R.id.item_logout) {
            startActivity(new Intent(this, login.class));
        }
        drawerLayout.closeDrawer(GravityCompat.END);
        return true;
    }
    protected void onPushButtonClick(){

    }

}
