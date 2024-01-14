package com.shashank.unittestingdemo.api

import com.shashank.unittestingdemo.model.dto.Employee
import retrofit2.http.GET

interface TestEmployeeApi {

    @GET("employees")
    suspend fun getEmployees(): Employee
}