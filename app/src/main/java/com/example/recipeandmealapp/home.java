package com.example.recipeandmealapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ImageView imageView1 = findViewById(R.id.imageView1);
        ImageView imageView2 = findViewById(R.id.imageView2);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity when imageView1 is clicked
                Intent intent = new Intent(home.this, recipes_list.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the new activity when imageView2 is clicked
                Intent intent = new Intent(home.this, plan_list.class);
                startActivity(intent);
            }
        });

        Button btnRecipe1 = findViewById(R.id.food_btn1);
        btnRecipe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, recipe_1.class);
                startActivity(intent);
            }
        });

        Button btnRecipe2 = findViewById(R.id.food_btn2);
        btnRecipe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, recipe_2.class);
                startActivity(intent);
            }
        });

        Button btnPlan1 = findViewById(R.id.plan_btn2);
        btnPlan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(home.this, plan_1.class);
                startActivity(intent);
            }
        });

//        Button btnPlan2 = findViewById(R.id.plan_btn1);
//        btnPlan2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(home.this, week_plan.class);
//                startActivity(intent);
//            }
//        });



    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

}