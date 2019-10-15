package com.square.di.module

import com.square.ui.RepoListActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun repoListActivity(): RepoListActivity

}