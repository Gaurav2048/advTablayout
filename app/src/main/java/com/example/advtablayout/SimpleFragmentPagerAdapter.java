package com.example.advtablayout;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.advtablayout.Fragment.FirstFragment;
import com.example.advtablayout.Fragment.FourthFragment;
import com.example.advtablayout.Fragment.SecondFragment;
import com.example.advtablayout.Fragment.ThirdFragment;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    // This determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new FirstFragment();
        } else if (position == 1){
            return new SecondFragment();
        } else if (position == 2){
            return new ThirdFragment();
        } else {
            return new FourthFragment();
        }
    }

    // This determines the number of tabs
    @Override
    public int getCount() {
        return 4;
    }

    // This determines the title for each tab
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:
                return mContext.getString(R.string.first);
            case 1:
                return mContext.getString(R.string.second);
            case 2:
                return mContext.getString(R.string.third);
            case 3:
                return mContext.getString(R.string.fourth);
            default:
                return null;
        }
    }

}