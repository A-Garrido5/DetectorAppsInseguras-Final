package com.example.adrin.detectorappsinseguras;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Adrián on 31-05-2015.
 */
public class viewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments;

    public viewPagerAdapter(FragmentManager fm) {

        super(fm);

        fragments =new ArrayList<Fragment>();
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return fragments.size();
    }

    public void addFragment(Fragment xfragment){
        this.fragments.add(xfragment);
    }



}
