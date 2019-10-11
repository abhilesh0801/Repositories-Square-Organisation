package com.poqtest.di.component

import android.app.Application
import com.poqtest.RepoApplication
import com.poqtest.di.module.ActivityModule
import com.poqtest.di.module.AppModule
import com.poqtest.di.module.ContextModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, ContextModule::class, AppModule::class, ActivityModule::class])
interface AppComponent  {
    fun inject(app: RepoApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}