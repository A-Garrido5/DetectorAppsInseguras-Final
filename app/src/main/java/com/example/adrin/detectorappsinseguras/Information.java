package com.example.adrin.detectorappsinseguras;

import java.util.Locale;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.viewpagerindicator.*;



public class Information extends ActionBarActivity {


    viewPagerAdapter mSectionsPagerAdapter;

    Context mContext=this;


    ViewPager mViewPager;



    public static Integer [] mImagesId={
            R.drawable.icono,
            R.drawable.lista,
            R.drawable.descripcion,
            R.drawable.warning,
            R.drawable.uninstall,
            R.drawable.permisos,
            R.drawable.cryto,
            R.drawable.publicidad,
            R.drawable.consejos

    };

    public  static Integer tamaño=mImagesId.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.color_app));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        mSectionsPagerAdapter = new viewPagerAdapter(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.pager);

        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(0, mImagesId[0],tamaño,mContext));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(1, mImagesId[1],tamaño,mContext));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(2,  mImagesId[2],tamaño,mContext));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(3,  mImagesId[3],tamaño,mContext));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(4,  mImagesId[4],tamaño,mContext));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(5,  mImagesId[5],tamaño,mContext));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(6,  mImagesId[6],tamaño,mContext));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(7, mImagesId[7], tamaño,mContext));
        mSectionsPagerAdapter.addFragment(Fragmentos.newInstance(8, mImagesId[8], tamaño,mContext));

        mViewPager.setAdapter(mSectionsPagerAdapter);


        CirclePageIndicator indicator = (CirclePageIndicator)findViewById(R.id.titles);
        indicator.setViewPager(mViewPager);





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_information, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        onBackPressed();
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }





}
