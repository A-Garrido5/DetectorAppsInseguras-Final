package com.example.adrin.detectorappsinseguras;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Adri�n on 31-05-2015.
 */
public class Fragmentos extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private  static final String ARG_TAMAÑO = "tamaño";
    private static final String IMAGE_VIEW = "image";

    private int section_number,image,tamaño;

    Context context;


    public static Fragmentos newInstance(int sectionNumber, int image, int tamaño, Context mContext) {
        Fragmentos fragment = new Fragmentos(mContext);
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putInt(ARG_TAMAÑO,tamaño);
        args.putInt(IMAGE_VIEW,image);
        fragment.setArguments(args);
        fragment.setRetainInstance(true);
        return fragment;
    }

    public Fragmentos(Context context) {

        this.context=context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            this.section_number = getArguments().getInt(ARG_SECTION_NUMBER);
            this.tamaño=getArguments().getInt(ARG_TAMAÑO);
            this.image = getArguments().getInt(IMAGE_VIEW);
        }
        else{
            this.section_number = (int)(Math.random() * 5);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_information, container, false);

        TextView info = (TextView) rootView.findViewById(R.id.informacion);
        TextView index =(TextView) rootView.findViewById(R.id.index);


            if(section_number==0) {
                info.setText(context.getResources().getString(R.string.page1));
                index.setText(String.valueOf(section_number + 1) + "/" + String.valueOf(tamaño));
            }

            else if(section_number==1) {
                info.setText(context.getResources().getString(R.string.page2));
                index.setText(String.valueOf(section_number + 1) + "/" + String.valueOf(tamaño));
            }

            else if(section_number==2) {
                info.setText(context.getResources().getString(R.string.page3));
                index.setText(String.valueOf(section_number + 1) + "/" + String.valueOf(tamaño));
            }

            else if(section_number==3) {
                info.setText(context.getResources().getString(R.string.page4));
                index.setText(String.valueOf(section_number + 1) + "/" + String.valueOf(tamaño));
            }
                else if(section_number==4) {
                info.setText(context.getResources().getString(R.string.page5));
                index.setText(String.valueOf(section_number + 1) + "/" + String.valueOf(tamaño));
            }


            else if(section_number==5){
                info.setText(context.getResources().getString(R.string.page6));
                index.setText(String.valueOf(section_number+1)+"/"+String.valueOf(tamaño));
            }

            else if(section_number==6){
                info.setText(context.getResources().getString(R.string.page7));
                index.setText(String.valueOf(section_number+1)+"/"+String.valueOf(tamaño));
            }

        else if(section_number==7){
            info.setText(context.getResources().getString(R.string.page8));
            index.setText(String.valueOf(section_number+1)+"/"+String.valueOf(tamaño));
        }

        else if(section_number==8){
            info.setText(context.getResources().getString(R.string.page9));
            index.setText(String.valueOf(section_number+1)+"/"+String.valueOf(tamaño));
        }



        ImageView imagen=(ImageView) rootView.findViewById(R.id.imageView4);
        imagen.setImageResource(image);




        return rootView;
    }
}