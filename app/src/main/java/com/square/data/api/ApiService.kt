package com.square.data.api

import com.square.data.model.Repo
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("/orgs/square/repos")
    fun getRepositories(): Observable<List<Repo>>
}