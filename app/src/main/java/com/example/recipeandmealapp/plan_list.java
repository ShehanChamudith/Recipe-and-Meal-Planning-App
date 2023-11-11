package com.example.recipeandmealapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class plan_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_list);

        CardView cardView2 = findViewById(R.id.planlist2);
        // Repeat for other CardViews...

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click for the first CardView
                startActivity(new Intent(plan_list.this, plan_1.class));
            }
        });




    }

}