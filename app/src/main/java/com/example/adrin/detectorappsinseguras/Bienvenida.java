package com.example.adrin.detectorappsinseguras;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Bienvenida extends ActionBarActivity{

    Button boton_analizar,boton_consejos;

    boolean checkConection=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.color_app));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        //Capturando la info del boton
        boton_analizar = (Button) findViewById(R.id.button_analizar);
        boton_analizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkConection=isOnline();
                if(checkConection){

                    Intent intent = new Intent(Bienvenida.this,Lista.class);
                    startActivity(intent);

                }

                else{
                    Toast.makeText(Bienvenida.this, "No hay conexión a Internet", Toast.LENGTH_SHORT).show();
                }
            }
        });

        boton_consejos = (Button) findViewById(R.id.button);
        boton_consejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent advice = new Intent(Bienvenida.this, Consejos.class);
                startActivity(advice);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bienvenida, menu);
        return true;

    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }

        return false;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_help) {
            Intent info = new Intent(this,Information.class);
            startActivity(info);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

  
}
