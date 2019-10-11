package com.poqtest.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.poqtest.data.repository.RepoRepository
import com.poqtest.ui.RepoListViewModel
import java.lang.IllegalArgumentException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(private val repository: RepoRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(RepoListViewModel::class.java)) {
            return RepoListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}