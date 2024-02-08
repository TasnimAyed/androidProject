package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the login and signup buttons
        Button loginButton = findViewById(R.id.loginButton);
        Button signupButton = findViewById(R.id.signupButton);

        // Set click listener for the login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the LoginActivity
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });

        // Set click listener for the signup button
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the SignupActivity
                Intent intent = new Intent(MainActivity.this, signupActivity.class);
                startActivity(intent);
            }
        });
    }
}
