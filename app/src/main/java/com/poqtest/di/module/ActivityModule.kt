package com.poqtest.di.module

import com.poqtest.ui.RepoListActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun repoListActivity(): RepoListActivity

}