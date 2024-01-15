package com.shashank.unittestingdemo.database

import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.shashank.unittestingdemo.model.repository.DatabaseRepository
import com.shashank.unittestingdemo.model.room.dao.EmployeeDao
import com.shashank.unittestingdemo.model.room.database.EmployeeRoomDatabase
import com.shashank.unittestingdemo.model.room.entity.EmployeeEntity
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest: TestCase() {
    private lateinit var roomDatabase: EmployeeRoomDatabase
    private lateinit var roomDao: EmployeeDao
    private lateinit var databaseRepository: DatabaseRepository
    private val TAG = "Database Test:"

    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        roomDatabase = EmployeeRoomDatabase.getInstance(context = context)
        roomDao = roomDatabase.employeeDao()
        databaseRepository = DatabaseRepository(roomDao)
        Log.i(TAG, "createDb")
    }

    @After
    fun closeDB() {
        if(::roomDatabase.isInitialized) {
            roomDatabase.close()
            Log.i(TAG, "closeDB")
        }
    }

    @Test
    fun insertRoomItem() {
        Log.d("Database: ", "insertRoomItem Test...")
        val roomItem = EmployeeEntity(
            2,
            "Antra Gupta",
            "Software Developer",
            "Working"
        )
        Log.d(TAG, "databaseRepository initialised Test...")
        runBlocking {
            databaseRepository.addEmployee(roomItem)
        }
        getEmployees()
    }

    fun getEmployees() {
        Log.d(TAG, "getEmployees Test...")
        val retrieveData = databaseRepository.getAllEmployees()
        Log.d(TAG, "getEmployees: $retrieveData")
        assertEquals(retrieveData.isNotEmpty(), true)
    }
}