package com.example.adrin.detectorappsinseguras;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Consejos extends ActionBarActivity{

    HashMap<String,List<String>> Advices;
    List<String> Advices_list;
    ExpandableListView Exp_list;
    PrimerAdaptador adaptador;

    Context context = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.color_app));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        Exp_list= (ExpandableListView) findViewById(R.id.exp_list);

        Advices = DataProvider.getInfo(context);

        Advices_list = new ArrayList<>(Advices.keySet());
        adaptador= new PrimerAdaptador(this,Advices,Advices_list);
        Exp_list.setAdapter(adaptador);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consejos, menu);
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


