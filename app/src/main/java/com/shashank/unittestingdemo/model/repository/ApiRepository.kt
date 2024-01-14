package com.shashank.unittestingdemo.model.repository

import com.shashank.unittestingdemo.model.api.RetrofitInstance
import com.shashank.unittestingdemo.model.dto.Employee

class ApiRepository {

    private val employeeService = RetrofitInstance.getEmployeeService

    suspend fun getEmployee(): Employee {
        return employeeService.getEmployees()
    }
}