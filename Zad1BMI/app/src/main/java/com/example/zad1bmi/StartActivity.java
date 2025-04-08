package com.example.zad1bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The StartActivity class represents the application's start screen.
 * It provides navigation to the main activity (MainActivity).
 */
public class StartActivity extends AppCompatActivity {

    /**
     * Called when the activity is created.
     * Sets up the layout and initializes UI components.
     *
     * @param savedInstanceState The saved state of the application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnStart = findViewById(R.id.btnStart);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

