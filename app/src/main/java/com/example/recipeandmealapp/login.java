package com.example.recipeandmealapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });

        Button btnStart = findViewById(R.id.btnLog);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get references to the EditText fields for username and password
                EditText usernameEditText = findViewById(R.id.un);
                EditText passwordEditText = findViewById(R.id.pw);

                // Get the input values
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Check if the provided username and password match the stored values
                if (checkCredentials(username, password)) {
                    // If the credentials are correct, open the home activity
                    Intent intent = new Intent(login.this, home.class);
                    startActivity(intent);
                } else {
                    // If the credentials are incorrect, show an error message
                    Toast.makeText(login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView registerTextView = findViewById(R.id.register);
        SpannableString spannableString = new SpannableString("Don't have an account? Register Here");

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(ContextCompat.getColor(this, R.color.lavender));

        spannableString.setSpan(colorSpan, spannableString.length() - "Register Here".length(), spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        registerTextView.setText(spannableString);
    }

    private boolean checkCredentials(String username, String password) {
        // Retrieve stored user data from SharedPreferences
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String storedUsername = preferences.getString("username", "");
        String storedPassword = preferences.getString("password", "");

        // Check if the provided username and password match the stored values
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
}