package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import java.util.HashMap;
import java.util.Map;

public class loginActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText;
    // Define your API endpoint URL
    private static final String LOGIN_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize EditText fields
        emailEditText = findViewById(R.id.Email);
        passwordEditText = findViewById(R.id.Password);
    }

    // Method to handle login button click
    public void onLoginClick(View view) {
        // Retrieve email and password from EditText fields
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Perform basic validation
        if (email.isEmpty() || password.isEmpty()) {
            // Show a toast indicating input error if email or password is empty
            Toast.makeText(this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
        } else {
            // Make an HTTP POST request to your API endpoint
            StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Handle API response
                            if (response.equals("success")) {
                                // Credentials are valid, navigate to main activity
                                Intent intent = new Intent(loginActivity.this, GitStartedActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                // Credentials are invalid, display error message
                                Toast.makeText(loginActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Handle error response
                            Toast.makeText(loginActivity.this, "Error occurred: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    // Pass user's email and password as parameters to the API endpoint
                    Map<String, String> params = new HashMap<>();
                    params.put("email", email);
                    params.put("password", password);
                    return params;
                }
            };

            // Add the request to the RequestQueue
            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(stringRequest);
        }
    }

    // Method to handle Sign Up text click
    public void onSignupClick(View view) {
        Intent intent = new Intent(loginActivity.this, signupActivity.class);
        startActivity(intent);
    }
}
