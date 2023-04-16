package com.github.takahirom.roborazzi.sample

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.RoborazziRule
import com.github.takahirom.roborazzi.captureRoboGif
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
class RoborazziRuleDemoTest {
    @get:Rule
    val roborazziRule = RoborazziRule(onView(isRoot()))

    @Test
    fun captureRoboGifSample() {
        onView(ViewMatchers.isRoot())
            .captureRoboGif("build/test.gif") {
                // launch
                ActivityScenario.launch(MainActivity::class.java)
                // move to next page
                onView(withId(R.id.button_first))
                    .perform(click())
                // back
                pressBack()
                // move to next page
                onView(withId(R.id.button_first))
                    .perform(click())
            }
    }
}
