package com.poqtest.ui

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
public class RepoListActivityTest {

    @Rule
    var repoListActivityTestRule: ActivityTestRule<RepoListActivity> = ActivityTestRule(RepoListActivity::class.java)


    @Test
    public fun recyclerViewTest() {
    }
}