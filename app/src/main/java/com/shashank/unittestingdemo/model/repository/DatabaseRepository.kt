package com.shashank.unittestingdemo.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.shashank.unittestingdemo.model.room.dao.EmployeeDao
import com.shashank.unittestingdemo.model.room.entity.EmployeeEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DatabaseRepository(private val employeeDao: EmployeeDao) {


    val allEmployees = MutableLiveData<List<EmployeeEntity>>()
    val foundEmployee = MutableLiveData<EmployeeEntity>()


    suspend fun addEmployee(newEmployee: EmployeeEntity) {
        Log.d("Database: ", "employeeDao adding employee into table...")
        employeeDao.addEmployee(newEmployee)
    }

    suspend fun updateEmployeeDetails(newEmployee: EmployeeEntity) {
        employeeDao.updateEmployeeDetails(newEmployee)
    }

    fun getAllEmployees() : List<EmployeeEntity>{
        return employeeDao.getAllEmployees()
    }

}