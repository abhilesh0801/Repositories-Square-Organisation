package com.poqtest

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import com.poqtest.ui.RepoListActivity
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RepoListActivityTest {

    @Rule
    @JvmField
    var repoListActivityTestRule = ActivityTestRule(RepoListActivity::class.java)

    private val packageName = BuildConfig.APPLICATION_ID

    private lateinit var device: UiDevice

    @Before
    fun setup() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
    }

    @Test
    public fun uiElementsExists() {
        val tvMessage = device.findObject(UiSelector().resourceId("$packageName:id/tvMessage"))
        val btnRetry = device.findObject(UiSelector().resourceId("$packageName:id/btnRetry"))
        val recyclerView = device.findObject(UiSelector().resourceId("$packageName:id/recyclerView"))
        val progressBar = device.findObject(UiSelector().resourceId("$packageName:id/progressBar"))
        Assert.assertTrue(tvMessage.exists())
        Assert.assertTrue(btnRetry.exists())
        Assert.assertTrue(recyclerView.exists())
        Assert.assertTrue(progressBar.exists())
    }
}