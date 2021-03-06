package com.example.adrin.detectorappsinseguras.controlador;

import android.content.Context;
import android.os.AsyncTask;

import com.example.adrin.detectorappsinseguras.Lista;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Seba on 15/05/2015.
 */
public class LectDB extends AsyncTask<Integer, Integer, Boolean>
{
    //CONSTANTE
    public static final String URL_DB = "http://clabu.16mb.com/clabuconnect/get_all_apps.php";

    //Atributos
    private Context mcontext;
    private JSONObject json;
    private Boolean estadoTerminado;
    private int conexion;

    public LectDB(Context c)
    {
        this.mcontext = c;
        //dbManager = new DBManager(mcontext);
    }

    protected Boolean doInBackground(Integer... integers)
    {
        this.estadoTerminado = false;
        //Checando si ahi conexion a la internete
        if(ConnectionDetected.isNetworkAvailable(mcontext)==0)
        {
            return false;
        }

        if(ConnectionDetected.isNetworkAvailable(mcontext)==-1)
        {
            this.conexion=-1;
        }


        //int idCategoria = integers[0];
        //Cursor cursor = dbManager.buscandoIDCategoria(idCategoria);
        try{
            //Actualizando la info:
            URL url = new URL(URL_DB);
            URLConnection uc = url.openConnection();
            uc.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String linea = br.readLine();

            System.out.println("Linea leida: "+ linea);
            try
            {
                json = new JSONObject(linea);
                this.estadoTerminado = true;
            }
            catch (JSONException e)
            {
                System.out.println("Error al crear el json: " + e);
            }

        } catch (MalformedURLException e) {
            System.out.println("Error al tomar el URL: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("al abrir la conexion: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("fin.");
        }

        return this.estadoTerminado;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if(aBoolean)
        {
            System.out.println("DB cargada OK");
            //Lista.datosDB(json);
        }
    }

    public JSONObject getDB()
    {
        return json;
    }

    public Boolean getEstadoTerminado()
    {
        return this.estadoTerminado;
    }

    public int getConexion()
    {
        return this.conexion;
    }
}
