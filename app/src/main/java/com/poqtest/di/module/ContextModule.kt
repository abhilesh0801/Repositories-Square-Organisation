package com.poqtest.di.module

import android.content.Context
import com.poqtest.RepoApplication
import dagger.Binds
import dagger.Module

@Module
abstract class ContextModule {

    @Binds
    abstract fun provideContext(application: RepoApplication): Context

}