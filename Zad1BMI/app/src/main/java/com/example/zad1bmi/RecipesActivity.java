package com.example.zad1bmi;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * The RecipesActivity class is responsible for displaying a list of recipes based on the user's daily caloric needs (TDEE).
 * It retrieves the caloric requirement from the previous activity and filters available recipes accordingly.
 */
public class RecipesActivity extends AppCompatActivity {

    TextView recipeTitle;
    TextView recipePlan;
    String[] recipes;
    int index = 0;
    List<String> filteredRecipes;

    /**
     * Called when the activity is created.
     * Initializes the UI components, retrieves the caloric needs from the previous activity,
     * and filters the recipes based on the caloric value.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        recipeTitle = findViewById(R.id.recipeTitle);
        recipePlan = findViewById(R.id.recipePlan);

        int caloriesNeeded = getIntent().getIntExtra("CALORIES_NEEDED", 0);

        recipes = getResources().getStringArray(R.array.recipes);
        filteredRecipes = new ArrayList<>();

        for (String recipe : recipes) {
            if (recipe.startsWith(caloriesNeeded + " kcal")) {
                String[] parts = recipe.split("\\|", 2);
                if (parts.length > 1) {
                    filteredRecipes.add(parts[1].trim());
                }
            }
        }

        if (filteredRecipes.isEmpty()) {
            recipeTitle.setText("No recipes for " + caloriesNeeded + " kcal");
            recipePlan.setText("");
        } else {
            recipeTitle.setText("Recipes for " + caloriesNeeded + " kcal");
            displayRecipes();
        }
    }
    /**
     * Displays the filtered recipes in the UI.
     * Shows up to three recipes at a time, including their titles and preparation instructions.
     */
    private void displayRecipes() {
        StringBuilder displayText = new StringBuilder();

        for (int i = 0; i < 3 && index + i < filteredRecipes.size(); i++) {
            String recipe = filteredRecipes.get(index + i);
            String[] recipeParts = recipe.split("\\|");
            if (recipeParts.length > 1) {
                displayText.append(recipeParts[0]).append("\n").append(recipeParts[1]).append("\n\n");
            } else {
                displayText.append(recipe).append("\n\n");
            }
        }
        recipePlan.setText(displayText.toString());
    }
}
