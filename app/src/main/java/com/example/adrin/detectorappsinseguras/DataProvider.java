package com.example.adrin.detectorappsinseguras;

import android.content.Context;
import android.text.Html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Adrián on 25-05-2015.
 */
public class DataProvider {

    public static HashMap<String,List<String>> getInfo(Context context){

        HashMap<String,List<String>> adviceDetails = new HashMap<String,List<String>>();

        List<String> Consejo1 = new ArrayList<String>();
        Consejo1.add(context.getResources().getString(R.string.consejo1));

        List<String> Consejo2= new ArrayList<String>();
        Consejo2.add(context.getResources().getString(R.string.consejo2));

        List<String> Consejo3 = new ArrayList<String>();
        Consejo3.add(context.getResources().getString(R.string.consejo3));

        List<String> Consejo4 = new ArrayList<String>();
        Consejo4.add(context.getResources().getString(R.string.consejo4));

        List<String> Consejo5 = new ArrayList<String>();
        Consejo5.add(context.getResources().getString(R.string.consejo5));

        List<String> Consejo6 = new ArrayList<String>();
        Consejo6.add(context.getResources().getString(R.string.consejo6));


        adviceDetails.put("Cuidados con la información", Consejo1);
        adviceDetails.put("Leer los permisos ",Consejo2);
        adviceDetails.put("Desinstalar aplicaciones",Consejo3);
        adviceDetails.put("Apagar inalámbricos",Consejo4);
        adviceDetails.put("Cerrar sesión",Consejo5);
        adviceDetails.put("Instalación de apps",Consejo6);


        return adviceDetails;



    }
}
