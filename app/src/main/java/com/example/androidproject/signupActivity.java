package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidproject.R;
import models.User;
import API.FirebaseAPI;

public class signupActivity extends AppCompatActivity {

    EditText firstNameEditText, addressEditText, birthdayEditText, emailEditText, passwordEditText;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize EditText fields and Button
        firstNameEditText = findViewById(R.id.firstName);
        addressEditText = findViewById(R.id.address);
        birthdayEditText = findViewById(R.id.birthday);
        emailEditText = findViewById(R.id.Email);
        passwordEditText = findViewById(R.id.password);
        signupButton = findViewById(R.id.signupButton);

        // Set click listener for signupButton
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve data from EditText fields
                String name = firstNameEditText.getText().toString();
                String location = addressEditText.getText().toString();
                String birthday = birthdayEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                // Create a User object
                User user = new User(name, location, birthday, email, password);

                // Call FirebaseAPI to register the user
                FirebaseAPI firebaseAPI = new FirebaseAPI(signupActivity.this);
                try {
                    firebaseAPI.register(user, signupActivity.this);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Navigate back to the login page
                Intent intent = new Intent(signupActivity.this, loginActivity.class);
                startActivity(intent);
                finish(); // This prevents the user from returning to the signup page using the back button
            }
        });
    }
}
