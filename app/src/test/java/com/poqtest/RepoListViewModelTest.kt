package com.poqtest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.poqtest.data.repository.RepoRepository
import com.poqtest.ui.RepoListViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RepoListViewModelTest {

    @Rule
    @JvmField
    var instantExecutor = InstantTaskExecutorRule()

    @Mock
    private lateinit var mockRepository: RepoRepository

    private lateinit var repoListViewModel: RepoListViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repoListViewModel = RepoListViewModel(mockRepository)
    }

    @Test
    fun loadRepositories() {
        Mockito.doNothing().`when`(mockRepository).getRepositories()
    }

}