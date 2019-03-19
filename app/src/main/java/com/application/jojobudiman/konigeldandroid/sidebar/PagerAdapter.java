package com.application.jojobudiman.konigeldandroid.sidebar;

import android.content.Context;

import com.application.jojobudiman.konigeldandroid.R;
import com.application.jojobudiman.konigeldandroid.checkout.MainMenu;
import com.application.jojobudiman.konigeldandroid.checkout.MainMenu2;
import com.application.jojobudiman.konigeldandroid.transactions.Transactions;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private Context mContext;

    //Constructor to the class
    public PagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        if (position == 0) {
            return new MainMenu();
        } else if (position == 1){
            return new MainMenu2();
        } else {
            return new MainMenu();
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.custom);
            case 1:
                return mContext.getString(R.string.library);
            default:
                return null;
        }
    }
}

