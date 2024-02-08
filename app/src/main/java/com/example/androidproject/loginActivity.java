package com.example.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    // Method to handle Forget Password text click
    //public void onForgetPasswordClick(View view) {
        //Intent intent = new Intent(loginActivity.this, ForgetPasswordActivity.class);
      //  startActivity(intent);
    //}

    // Method to handle Sign Up text click
    public void onSignupClick(View view) {
        Intent intent = new Intent(loginActivity.this, signupActivity.class);
        startActivity(intent);
    }
}
