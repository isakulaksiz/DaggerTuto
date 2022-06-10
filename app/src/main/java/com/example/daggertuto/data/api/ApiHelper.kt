package com.example.daggertuto.data.api

import com.example.daggertuto.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}