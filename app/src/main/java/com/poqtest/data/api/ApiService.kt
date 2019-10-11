package com.poqtest.data.api

import com.poqtest.data.model.Repo
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("/orgs/square/repos")
    fun getRepositories(): Observable<List<Repo>>
}