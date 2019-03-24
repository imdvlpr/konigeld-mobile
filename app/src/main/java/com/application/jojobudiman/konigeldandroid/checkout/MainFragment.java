package com.application.jojobudiman.konigeldandroid.checkout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.products.Products;
import com.application.jojobudiman.konigeldandroid.settings.AccountSettings;
import com.application.jojobudiman.konigeldandroid.sidebar.PagerAdapter;
import com.application.jojobudiman.konigeldandroid.R;
import androidx.appcompat.app.ActionBarDrawerToggle;
import com.application.jojobudiman.konigeldandroid.sidebar.SidebarMenu;
import com.application.jojobudiman.konigeldandroid.transactions.Transactions;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

public class MainFragment extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActionBarDrawerToggle toggle;
    RelativeLayout topHeader;
    TabLayout selectButton;
    Toolbar toolbar;
    TextView logoutbtn;
    DrawerLayout drawer;

    NavigationView navigationView;
    private Fragment fragment = null;
    private FragmentManager fragmentManager;
    private MainMenu CustomFragment;
    private MainMenu2 LibraryFragment;
    private Transactions TransactionFragment;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sidebar_menu);

        drawer = findViewById(R.id.drawer_layout);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragment = new CustomMenu();
        fragmentTransaction.replace(R.id.main_container, fragment, "Test1");
        fragmentTransaction.commit();

        logoutbtn = (TextView) findViewById(R.id.logout);


        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        final ImageButton menu = (ImageButton) findViewById(R.id.hamburger);



    }

    @Override
    protected void onResume() {
        super.onResume();
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    protected void onPause() {
        super.onPause();
        drawer.removeDrawerListener(toggle);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        String title = "";
        if (id == R.id.nav_checkout) {
            title = "Current Sale";
            fragment = new CustomMenu();
        } else if (id == R.id.nav_transactions) {
            title = "Transactions";
            fragment = new Transactions();
        } else if (id == R.id.nav_products) {
            title= "Products";
            fragment = new Products();
        } else if (id == R.id.nav_settings) {
            title = "Settings";
            fragment = new AccountSettings();
        } else if (id== R.id.backmenu) {

        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.main_container, fragment);
        transaction.commit();

        /*if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content_main, fragment)
                    .commit();
        }*/

        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(title);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }



}


