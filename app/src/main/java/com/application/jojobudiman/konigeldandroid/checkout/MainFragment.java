package com.application.jojobudiman.konigeldandroid.checkout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.application.jojobudiman.konigeldandroid.products.Products;
import com.application.jojobudiman.konigeldandroid.settings.AccountSettings;
import com.application.jojobudiman.konigeldandroid.sidebar.PagerAdapter;
import com.application.jojobudiman.konigeldandroid.R;
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
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

public class MainFragment extends AppCompatActivity {
    RelativeLayout topHeader;
    TabLayout selectButton;
    Toolbar toolbar;
    Button charge;
    ImageView menu;
    TextView custom, library;
    private MainMenu CustomFragment;
    private MainMenu2 LibraryFragment;
    private Transactions TransactionFragment;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_menu);

        topHeader = (RelativeLayout) findViewById(R.id.topheader);
        selectButton = (TabLayout) findViewById(R.id.checkoutTabs);
        charge = (Button) findViewById(R.id.chargebtn);
        viewPager = (ViewPager) findViewById(R.id.container);
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);
        final ImageButton menu = (ImageButton) findViewById(R.id.hamburger);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(Gravity.LEFT);

            }
        });

        charge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),  ChargePayment.class);
                startActivity(i);
            }
        });

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), this);

        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        selectButton.setupWithViewPager(viewPager);

        CustomFragment = new MainMenu();
        LibraryFragment = new MainMenu2();

    }


    private void setFragment (Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    /*public void onClick(View v) {
        switch(v.getId()) {
            case R.id.menu:
                drawer.openDrawer(GravityCompat.START);
                Log.d("drawer", "Drawer opened!");
                break;
            default:
                break;
        }
    }*/

}
