package com.example.surf_kotl_mis1.model

import com.example.surf_kotl_mis1.model.LoginPost
import com.example.surf_kotl_mis1.model.User
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {
    @Headers("Content-Type: application/json")
    @POST("auth/login")
    fun postLogin(@Body User: User): retrofit2.Call<LoginPost>
}