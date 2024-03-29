package com.square.ui

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import com.square.BuildConfig
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RepoListActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(RepoListActivity::class.java)

    companion object {
        const val packageName = BuildConfig.APPLICATION_ID
    }

    private lateinit var device: UiDevice

    @Before
    fun setup() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    /*
    * Test if recyclerView exits on device screen
    */
    @Test
    fun uiElementsExist() {
        val recyclerView = device.findObject(UiSelector().resourceId("$packageName:id/recyclerView"))
        Assert.assertTrue(recyclerView.exists())
    }
}