package com.poqtest.data.repository

import com.poqtest.data.api.ApiService
import com.poqtest.data.model.Repo
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

//To be constructed only once
@Singleton
class RepoRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun getRepositories(): Observable<List<Repo>> {
        return apiService.getRepositories()
    }
}