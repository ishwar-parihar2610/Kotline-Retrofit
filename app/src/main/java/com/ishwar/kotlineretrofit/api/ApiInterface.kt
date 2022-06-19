package com.ishwar.kotlineretrofit.api

import com.ishwar.kotlineretrofit.model.Users
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/users")
    suspend fun getUsers():Response<Users>


}