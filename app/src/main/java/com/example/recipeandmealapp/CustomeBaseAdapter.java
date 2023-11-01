package com.example.recipeandmealapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomeBaseAdapter extends BaseAdapter {

    Context context;
    String recipeList[];
    int recipeImg[];
    LayoutInflater inflater;


    public CustomeBaseAdapter(Context ctx,String [] recipeList,int [] recipeImg){
        this.context=ctx;
        this.recipeList=recipeList;
        this.recipeImg=recipeImg;
        inflater=LayoutInflater.from(ctx);

    }

    @Override
    public int getCount() {
        return recipeList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_view, parent, false);
        }

        TextView txtView = (TextView) convertView.findViewById(R.id.listName);
        ImageView recipeImgs =(ImageView) convertView.findViewById(R.id.listImage);
        txtView.setText(recipeList[position]);
        recipeImgs.setImageResource( recipeImg [position]);
        return convertView;

    }
}
