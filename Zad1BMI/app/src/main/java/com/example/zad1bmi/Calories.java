package com.example.zad1bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;

/**
 * The Calories class calculates the user's daily caloric needs
 * based on their weight, height, age, gender, and activity level.
 */
public class Calories extends AppCompatActivity {

    private EditText weightEditText, heightEditText, ageEditText;
    private Spinner genderSpinner, activitySpinner;
    private Button calculateButton;
    private TextView resultTextView;

    /**
     * Called when the activity is created.
     * Initializes the UI components and sets up event listeners.
     *
     * @param savedInstanceState The saved state of the application.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        weightEditText = findViewById(R.id.weight);
        heightEditText = findViewById(R.id.height);
        ageEditText = findViewById(R.id.age);
        genderSpinner = findViewById(R.id.genderSpinner);
        activitySpinner = findViewById(R.id.activitySpinner);
        calculateButton = findViewById(R.id.calculateCaloriesNeededButton);
        resultTextView = findViewById(R.id.resultCalories);

        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.gender_options,
                android.R.layout.simple_spinner_item
        );
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        ArrayAdapter<CharSequence> activityAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.activity_levels,
                android.R.layout.simple_spinner_item
        );
        activityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(activityAdapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateCalories();
            }
        });

        Button recipesButton = findViewById(R.id.btnCulinaryRecommendations);
        recipesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Calories.this, RecipesActivity.class);
                startActivity(intent);
            }
        });

        recipesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultText = resultTextView.getText().toString();

                if (!resultText.startsWith("Your daily calorie need")) {
                    resultTextView.setText(getString(R.string.calculate_first));
                    return;
                }

                double tdeeValue = Double.parseDouble(resultText.replaceAll("[^0-9.]", ""));

                int[] availableCalories = {1000, 1200, 1600, 2000, 2400, 2800};

                int roundedCalories = availableCalories[0];
                for (int cal : availableCalories) {
                    if (cal <= tdeeValue) {
                        roundedCalories = cal;
                    } else {
                        break;
                    }
                }
                Intent intent = new Intent(Calories.this, RecipesActivity.class);
                intent.putExtra("CALORIES_NEEDED", roundedCalories);
                startActivity(intent);
            }
        });
    }

    /**
     * Calculates the user's daily caloric needs (TDEE) using the Harris-Benedict equation.
     * Takes into account weight, height, age, gender, and activity level.
     * Displays the result in the TextView.
     */
    private void calculateCalories() {
        String weightText = weightEditText.getText().toString();
        String heightText = heightEditText.getText().toString();
        String ageText = ageEditText.getText().toString();

        if (weightText.isEmpty() || heightText.isEmpty() || ageText.isEmpty()) {
            resultTextView.setText(getString(R.string.fill_all_fields));
            return;
        }

        float weight = Float.parseFloat(weightText);
        float height = Float.parseFloat(heightText) * 100;
        int age = Integer.parseInt(ageText);
        String selectedGender = genderSpinner.getSelectedItem().toString();

        double bmr;
        boolean isMale = selectedGender.equals(getString(R.string.gender_male));

        if (isMale) {
            bmr = 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
        } else {
            bmr = 447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age);
        }

        double[] activityMultipliers = {1.2, 1.375, 1.55, 1.725, 1.9};
        int activityIndex = activitySpinner.getSelectedItemPosition();

        double tdee = bmr * activityMultipliers[activityIndex];

        String result = String.format(Locale.US, getString(R.string.daily_calorie_need), tdee);
        resultTextView.setText(result);
    }
}
