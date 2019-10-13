package com.poqtest.di.module

import androidx.lifecycle.ViewModel
import com.poqtest.ui.RepoListViewModel
import com.poqtest.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RepoListViewModel::class)
    abstract fun bindRepoListViewModel(repoListViewModel: RepoListViewModel): ViewModel

}