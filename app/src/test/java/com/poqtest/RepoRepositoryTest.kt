package com.poqtest.data

import com.poqtest.data.repository.RepoRepository
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepoRepositoryTest {

    @Mock
    private lateinit var repository: RepoRepository

    @Before
    fun setUp() {
    }

    @Test
    fun getRepositories() {
        Mockito.doReturn(repository.getRepositories()).`when`(repository.getRepositories())
    }
}