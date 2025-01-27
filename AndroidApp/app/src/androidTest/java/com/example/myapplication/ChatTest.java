package com.example.myapplication;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChatTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void chatTest() throws InterruptedException {
        onView(withId(R.id.thirdFragment))
                .perform(click())
                .check(matches(isDisplayed()));

        Thread.sleep(2000);

        onData(anything()).inAdapterView(withId(R.id.chat_list)).atPosition(0).perform(click());

        Thread.sleep(2000);

        onView(withId(R.id.messages_view))
                .check(matches(isDisplayed()));

        assertEquals(1,1);
    }
}
