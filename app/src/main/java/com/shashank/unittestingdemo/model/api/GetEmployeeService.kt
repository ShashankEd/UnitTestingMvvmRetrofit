package com.shashank.unittestingdemo.model.api

import com.shashank.unittestingdemo.model.dto.Employee
import retrofit2.http.GET

interface GetEmployeeService {
    @GET("employees")
    suspend fun getEmployees(): Employee
}