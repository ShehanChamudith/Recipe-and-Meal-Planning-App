package com.example.recipeandmealapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class home2 extends AppCompatActivity {

    String recipeList[] = {"abcd","efgh"};
    int recipeImg [] ={R.drawable.abcd,R.drawable.efgh};

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        listView = (ListView) findViewById(R.id.list1);
        CustomeBaseAdapter customeBaseAdapter = new CustomeBaseAdapter(getBaseContext(),recipeList,recipeImg);
        listView.setAdapter(customeBaseAdapter);
    }
}