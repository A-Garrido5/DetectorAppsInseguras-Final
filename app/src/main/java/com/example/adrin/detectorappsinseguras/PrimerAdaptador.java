package com.example.adrin.detectorappsinseguras;

import android.content.Context;
import android.graphics.Typeface;
import android.media.Image;
import android.text.Html;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Adrián on 25-05-2015.
 */
public class PrimerAdaptador extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String, List<String>> Movies_Category;
    private List<String> Movies_List;

    public PrimerAdaptador(Context ctx,HashMap<String, List<String>> Movies_Category,List<String> Movies_List){
        this.ctx=ctx;
        this.Movies_Category = Movies_Category;
        this.Movies_List = Movies_List;

    }


    @Override
    public int getGroupCount() {
        return Movies_List.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return Movies_Category.get(Movies_List.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return Movies_List.get(groupPosition);
    }

    @Override
    public Object getChild(int parent, int child) {
        return Movies_Category.get(Movies_List.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int parent, int child) {

        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertView, ViewGroup parentview) {
        String gruop_title=(String)getGroup(parent);
        if(convertView==null){
            LayoutInflater inflator =(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflator.inflate(R.layout.parent_layout,parentview,false);
        }

        TextView parent_textview =(TextView) convertView.findViewById(R.id.parent_txt);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(gruop_title);

        return convertView;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertView, ViewGroup parentview) {

        String child_title = (String)getChild(parent,child);

        if(convertView==null){
            LayoutInflater inflator =(LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflator.inflate(R.layout.child_layout,parentview,false);
        }

        TextView child_textview = (TextView)convertView.findViewById(R.id.child_txt);

        ImageView child_imageview = (ImageView)convertView.findViewById(R.id.imageView);

        if(parent==0){

            child_imageview.setImageResource(R.drawable.papelera);

        }

        else if(parent==1)
            child_imageview.setImageResource(R.drawable.ladron);

        else if(parent==2)
            child_imageview.setImageResource(R.drawable.cs);

        else if(parent==3)
            child_imageview.setImageResource(R.drawable.man);

        else if(parent==4)
            child_imageview.setImageResource(R.drawable.play);

        else if(parent==5)
            child_imageview.setImageResource(R.drawable.nfc);


        //Log.d("Holaa",Integer.toString(parent));

        child_textview.setText(child_title);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
