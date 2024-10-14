package com.example.ortbetp3grupo5parcial.services

import com.example.ortbetp3grupo5parcial.models.LoginRequest
import com.example.ortbetp3grupo5parcial.models.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}