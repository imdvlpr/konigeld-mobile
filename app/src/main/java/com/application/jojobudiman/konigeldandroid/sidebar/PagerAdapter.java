package com.application.jojobudiman.konigeldandroid.sidebar;

import android.content.Context;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.CustomMenu;
import com.application.jojobudiman.konigeldandroid.checkout.MainMenu;
import com.application.jojobudiman.konigeldandroid.checkout.MainMenu2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;
    private static final int FRAGMENT_COUNT = 2;
    //integer to count number of tabs

    //Constructor to the class
    public PagerAdapter(FragmentManager fm) {
        super(fm);

    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position){
            case 0:
                return new MainMenu();
            case 1:
                return new MainMenu2();
        }
        return null;
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return "CUSTOM";
            case 1:
                return "LIBRARY";
            default:
                return null;
        }
    }
}

