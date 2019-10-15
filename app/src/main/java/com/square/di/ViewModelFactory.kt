package com.square.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.square.data.repository.RepoRepository
import com.square.ui.RepoListViewModel
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