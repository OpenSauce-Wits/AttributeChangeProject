package com.example.attributechangeproject;

import android.content.Context;
import android.graphics.Color;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void changeColor() throws Throwable {
        MainActivity mainActivity = mainActivityActivityTestRule.getActivity();
        final ConstraintLayout activityConstraintLayout = mainActivity.findViewById(R.id.constraintLayoutBackground);
        final int color = Color.argb(225, 200, 200, 200);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activityConstraintLayout.setBackgroundColor(color);
            }
        });
        ViewInteraction btnChangeBackground = onView(withId(R.id.btnChangeBackground));
        btnChangeBackground.perform(click());
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                assertNotEquals(color, activityConstraintLayout.getSolidColor());
            }
        });
    }

    @Test
    public void colorNotChanged() throws Throwable {
        MainActivity mainActivity = mainActivityActivityTestRule.getActivity();
        final ConstraintLayout activityConstraintLayout = mainActivity.findViewById(R.id.constraintLayoutBackground);
        final int color = Color.argb(225, 200, 200, 200);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                activityConstraintLayout.setBackgroundColor(color);
                assertNotEquals(color, activityConstraintLayout.getSolidColor());
            }
        });
    }
}
