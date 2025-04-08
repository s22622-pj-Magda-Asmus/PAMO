package com.example.zad1bmi;

import org.junit.Test;

import static org.junit.Assert.*;
import com.example.zad1bmi.utils.BmiUtils;

public class BmiUtilsTest {

    @Test
    public void calculateBMI_validData_shouldReturnExpectedValue() {
        // Given
        float weight = 110f;
        float height = 1.93f;
        float expected = 29.53f;

        // When
        float actual = BmiUtils.calculateBMI(weight, height);

        // Then
        assertEquals(expected, actual, 0.01f);
    }

}
