package com.example.zad1bmi.utils;

/**
 * Helper class for calculating BMI (Body Mass Index) and determining the BMI category.
 */
public class BmiUtils {

    /**
     * Calculates BMI (Body Mass Index).
     *
     * @param weight Weight in kilograms
     * @param height Height in meters
     * @return Calculated BMI
     * @throws IllegalArgumentException if height <= 0
     */
    public static float calculateBMI(float weight, float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        return weight / (height * height);
    }

    /**
     * Returns the BMI category based on the BMI value.
     * (Simplified version, returned as plain text.)
     *
     * @param bmi BMI value
     * @return A string representing the BMI category.
     */
    public static String getBMICategory(float bmi) {
        if (bmi < 18.5f) {
            return "Underweight";
        } else if (bmi < 24.9f) {
            return "Normal weight";
        } else if (bmi < 29.9f) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }
}
