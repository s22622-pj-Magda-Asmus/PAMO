package com.example.zad1bmi.utils;

/**
 * Klasa pomocnicza do obliczania wartości BMI i przypisywania kategorii.
 */
public class BmiUtils {

    /**
     * Oblicza BMI (Body Mass Index).
     *
     * @param weight Waga w kg
     * @param height Wzrost w metrach
     * @return Obliczone BMI
     * @throws IllegalArgumentException jeśli height <= 0
     */
    public static float calculateBMI(float weight, float height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be greater than 0");
        }
        return weight / (height * height);
    }

    /**
     * Zwraca kategorię BMI w zależności od wartości.
     * (Wersja uproszczona, zwracana jako zwykły tekst.)
     *
     * @param bmi wartość BMI
     * @return String z nazwą kategorii.
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
