package com.example.daggertuto.data.api

import com.example.daggertuto.data.model.User
import retrofit2.Response
import javax.inject.Inject

class ApiServiceImpl @Inject constructor(private val apiService: ApiService): ApiHelper {
    override suspend fun getUsers(): Response<List<User>> = apiService.getUsers()

}