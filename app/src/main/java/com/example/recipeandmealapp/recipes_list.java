package com.example.recipeandmealapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class recipes_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes_list);

        CardView cardView1 = findViewById(R.id.list1);
        // Repeat for other CardViews...

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for the first CardView
                startActivity(new Intent(recipes_list.this, recipe_1.class));
            }
        });

    }
}