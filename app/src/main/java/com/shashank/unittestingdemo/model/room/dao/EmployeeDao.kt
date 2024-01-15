package com.shashank.unittestingdemo.model.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.shashank.unittestingdemo.model.room.entity.EmployeeEntity

@Dao
interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addEmployee(employee: EmployeeEntity)

    @Query("SELECT * FROM employee WHERE id = :empId")
    fun findEmployeeById(empId: String): EmployeeEntity

    @Query("SELECT * FROM employee")
    fun getAllEmployees(): List<EmployeeEntity>

    @Update
    suspend fun updateEmployeeDetails(employee: EmployeeEntity)

    @Delete
    suspend fun deleteEmployee(employee: EmployeeEntity)
}