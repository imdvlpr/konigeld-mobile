package com.application.jojobudiman.konigeldandroid.sidebar;

import android.os.Bundle;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.MainMenu;

import android.util.Log;
import android.view.View;

import com.application.jojobudiman.konigeldandroid.products.Products;
import com.application.jojobudiman.konigeldandroid.settings.AccountSettings;
import com.application.jojobudiman.konigeldandroid.transactions.Transactions;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.widget.ImageView;

public class SidebarMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    DrawerLayout drawer;
    Toolbar toolbar;
    ImageView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidebar_menu);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        menu = (ImageView)findViewById(R.id.hamburger);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.hamburgermenu);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Bundle bundle = new Bundle();
        Fragment fragment = null;
        if (id == R.id.nav_checkout){
            fragment = new MainMenu();
        } else if (id == R.id.nav_transactions) {
            fragment = new Transactions();
        } else if (id == R.id.nav_products) {
            fragment = new Products();
        } else if (id == R.id.nav_settings) {
            fragment = new AccountSettings();
        }

        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, fragment)
                    .commit();
        }

        if (getSupportActionBar() != null)
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.menu:
               drawer.openDrawer(GravityCompat.START);
               Log.d("drawer", "Drawer opened!");
               break;
            default:
                break;
        }
    }

}







