package com.example.recipeandmealapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class register extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView register = findViewById(R.id.log);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this, login.class);
                startActivity(intent);
            }
        });

        final EditText editTextUsername = findViewById(R.id.editTextRegisterUsername);
        final EditText editTextEmail = findViewById(R.id.editTextRegisterEmail);
        final EditText editTextPassword = findViewById(R.id.editTextRegisterPassword);
        final EditText editTextRePassword = findViewById(R.id.editTextRegisterRePassword);
        Button btnRegister = findViewById(R.id.btnReg);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the entered values
                String username = editTextUsername.getText().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String rePassword = editTextRePassword.getText().toString();

                // Validate the entered values
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(rePassword)) {
                    Toast.makeText(register.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(email)) {
                    Toast.makeText(register.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(rePassword)) {
                    Toast.makeText(register.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Registration successful
                    Toast.makeText(register.this, "Registration successful", Toast.LENGTH_SHORT).show();

                    // Save the entered values using SharedPreferences
                    saveUserData(username, email, password);

                    // Optionally, you can navigate to another screen or perform additional actions
                }
            }
        });

        TextView registerTextView = findViewById(R.id.log);
        SpannableString spannableString = new SpannableString("Already have an account? Log in Here");

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(ContextCompat.getColor(this, R.color.lavender));

        spannableString.setSpan(colorSpan, spannableString.length() - "Log in Here".length(), spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        registerTextView.setText(spannableString);

    }

    // Email validation using a regular expression
    private boolean isValidEmail(CharSequence email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    // Save user data using SharedPreferences
    private void saveUserData(String username, String email, String password) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", username);
        editor.putString("email", email);
        editor.putString("password", password);
        editor.apply();
    }

    public void goBackToHome(View view) {
        // Handle the click to go back to the home screen
        startActivity(new Intent(this, home.class));
        finish(); }


}

