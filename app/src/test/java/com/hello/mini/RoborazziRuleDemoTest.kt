package com.hello.mini

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.RoborazziRule
import com.github.takahirom.roborazzi.captureRoboImage
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
    fun case_0_generate_default_snapshot() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(isRoot()).captureRoboImage()
    }

}
