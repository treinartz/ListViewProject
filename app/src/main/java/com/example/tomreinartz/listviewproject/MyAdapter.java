package com.example.tomreinartz.listviewproject;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.ImageView;

/**
 * Created by tomreinartz on 2/11/16.
 */
public class MyAdapter extends ArrayAdapter<String> {

    public MyAdapter(Context context, String [] values){
        super(context, R.layout.row_layout2, values);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        //return super.getView(position, convertView, parent);
        LayoutInflater theInflater =LayoutInflater.from(getContext());
        View theView= theInflater.inflate(R.layout.row_layout2, parent, false);

        String dinosaurs=getItem(position);
        TextView theTextView=(TextView)theView.findViewById(R.id.textView1);
        theTextView.setText(dinosaurs);

        ImageView theImageView=(ImageView)theView.findViewById(R.id.imageView1);
        theImageView.setImageResource(R.drawable.rex);
        return theView;
    }




}
