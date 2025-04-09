package com.example.zad1bmi;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Before
    public void setUp() {
        ActivityScenario.launch(MainActivity.class);
    }

    @Test
    public void testCalculateBMI_ShowsCorrectResult() {
        onView(withId(R.id.weight))
                .perform(clearText(), typeText("70"), closeSoftKeyboard());

        onView(withId(R.id.height))
                .perform(clearText(), typeText("1.75"), closeSoftKeyboard());

        onView(withId(R.id.button)).perform(click());

        onView(withId(R.id.resultBMI))
                .check(matches(withText("BMI = 22.86 (Normal weight)")));
    }
}
