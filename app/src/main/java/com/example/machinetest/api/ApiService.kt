package com.example.machinetest.api

import com.example.machinetest.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getUsers(@Query ("page") page:Int): Call<UserResponse>

}