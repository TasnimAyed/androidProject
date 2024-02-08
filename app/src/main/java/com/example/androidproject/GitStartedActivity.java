package com.example.androidproject;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class GitStartedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_started);

        TextView textView = findViewById(R.id.textView);

        // Load the font programmatically
        Typeface typeface = ResourcesCompat.getFont(this, R.font.proteststrikeregular);

        // Apply the font to the TextView
        textView.setTypeface(typeface);

        // Get the "Get Started" button
        Button getStartedButton = findViewById(R.id.getStartedButton);

        // Set OnClickListener to the button
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to MainActivity
                Intent intent = new Intent(GitStartedActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
