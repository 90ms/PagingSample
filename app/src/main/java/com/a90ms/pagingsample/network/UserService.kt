package com.a90ms.pagingsample.network

import com.a90ms.pagingsample.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("/")
    suspend fun getUserList(): List<User>

    @GET("user/{id}/")
    suspend fun getUserInfo(@Path("id") id: Int): User
}