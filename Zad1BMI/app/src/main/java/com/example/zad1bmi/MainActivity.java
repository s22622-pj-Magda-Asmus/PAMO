package com.example.zad1bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
/**
 * Main activity of the BMI Calculator app.
 */
public class MainActivity extends AppCompatActivity {


    /**
     * EditText fields for user to enter weight and height.
     */
    EditText weightEditText, heightEditText;
    /**
     * Button to trigger BMI calculation.
     */
    Button calculateButton;
    /**
     * TextView to display the BMI result.
     */
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
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    /**
     * Calculates the BMI based on the entered weight and height.
     * The result is displayed in the resultTextView along with the BMI category.
     */
    private void calculateBMI() {
        String weightText = weightEditText.getText().toString();
        String heightText = heightEditText.getText().toString();

        if (weightText.isEmpty() || heightText.isEmpty()) return;

        try {
            float weight = Float.parseFloat(weightText);
            float height = Float.parseFloat(heightText);

            if (height == 0) return;

            float bmi = weight / (height * height);
            String bmiCategory = getBMICategory(bmi);
            String bmiResult = String.format("Your BMI is: %.2f\nCategory: %s", bmi, bmiCategory);
            resultTextView.setText(bmiResult);

        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input.");
        }
    }

    /**
     * Determines the BMI category based on the BMI value.
     *
     * @param bmi The calculated BMI.
     * @return The BMI category as a string.
     */
    private String getBMICategory(float bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}
