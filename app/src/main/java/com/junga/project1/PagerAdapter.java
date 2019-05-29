package com.junga.project1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int numOfFragment;

    public PagerAdapter(FragmentManager fm,int numOfFragment) {
        super(fm);
        this.numOfFragment = numOfFragment;
    }

    @Override
    public Fragment getItem(int i) {

        switch(i){
            case 0:
                DrinkFragment fragment1 = new DrinkFragment();
                Bundle bundle = new Bundle();
                bundle.putInt("type",0);
                fragment1.setArguments(bundle);
                return fragment1;
            case 1:
                DrinkFragment fragment2 = new DrinkFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putInt("type",1);
                fragment2.setArguments(bundle2);
                return fragment2;

            case 2:
                DrinkFragment fragment3 = new DrinkFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putInt("type",2);
                fragment3.setArguments(bundle3);
                return fragment3;

            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return numOfFragment;
    }
}
