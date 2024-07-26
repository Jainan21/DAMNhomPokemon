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

        Toolbar toolbar = findViewById(R.id.header);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.Nav_bar);
        navigationView.setNavigationItemSelectedListener(this);

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

    protected void setupActionBarAndBack(int layoutResID, String title) {
        setContentView(layoutResID);

        Toolbar toolbar = findViewById(R.id.header2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);


        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.Nav_bar);
        navigationView.setNavigationItemSelectedListener(this);


        Button menu = findViewById(R.id.btnMenuHd2);
        Button before = findViewById(R.id.btnBeforeHd2);
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
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        Intent intent = null;
        int id = item.getItemId();
        if (id == R.id.iconHome) {
            // If already in MainActivity, no need to navigate again
            if (!(this instanceof BookView)) {
                intent = new Intent(this, BookView.class);
            }
        }
        else if (id == R.id.item_account) {
            Toast.makeText(this, "Quan ly nguoi doc", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.item_search) {
            fragment = new SearchingView();
        } else if (id == R.id.item_bookshelf) {
            Toast.makeText(this, "Tur sasch cas nhaan", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.item_logout) {
            startActivity(new Intent(this, login.class));
        }

        if (intent != null) {
            startActivity(intent);
            finish();
        } else if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.Frame_menu, fragment);
            fragmentTransaction.commit();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.Frame_menu, fragment)
                .commit();
        drawerLayout.closeDrawer(GravityCompat.END);
        return true;
    }

}
