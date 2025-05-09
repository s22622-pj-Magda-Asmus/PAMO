package com.example.zad1bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.example.zad1bmi.utils.BmiUtils;

/**
 * Main activity of the BMI Calculator app.
 */
public class MainActivity extends AppCompatActivity {

    EditText weightEditText, heightEditText;
    Button calculateButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weight);
        heightEditText = findViewById(R.id.height);
        calculateButton = findViewById(R.id.button);
        resultTextView = findViewById(R.id.resultBMI);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });

        Button caloriesButton = findViewById(R.id.btnGoToCalories);
        caloriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calories.class);
                startActivity(intent);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadData("<h1>Test WebView działa!</h1>", "text/html", "UTF-8");
        webView.loadUrl("file:///android_asset/chart.html");

    }

    /**
     * Calculates the BMI based on the entered weight and height,
     * then updates resultTextView with the value and category.
     */
    private void calculateBMI() {
        String weightText = weightEditText.getText().toString();
        String heightText = heightEditText.getText().toString();

        if (weightText.isEmpty() || heightText.isEmpty()) {
            resultTextView.setText(getString(R.string.invalid_input));
            return;
        }

        try {
            float weight = Float.parseFloat(weightText);
            float height = Float.parseFloat(heightText);

            float bmi = BmiUtils.calculateBMI(weight, height);
            String category = BmiUtils.getBMICategory(bmi);

            String resultText = String.format(
                    Locale.US,
                    "BMI = %.2f (%s)",
                    bmi,
                    category
            );

            resultTextView.setText(resultText);

        } catch (NumberFormatException e) {
            resultTextView.setText(getString(R.string.invalid_input));
        } catch (IllegalArgumentException e) {
            resultTextView.setText(getString(R.string.invalid_input));
        }
    }
}
