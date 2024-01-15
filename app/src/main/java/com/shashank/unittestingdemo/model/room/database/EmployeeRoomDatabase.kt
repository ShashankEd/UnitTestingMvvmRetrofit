package com.shashank.unittestingdemo.model.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shashank.unittestingdemo.model.room.dao.EmployeeDao
import com.shashank.unittestingdemo.model.room.entity.EmployeeEntity

@Database(entities = [(EmployeeEntity::class)], version = 1, exportSchema = false)
abstract class EmployeeRoomDatabase: RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao
    companion object {

        @Volatile
        private var INSTANCE: EmployeeRoomDatabase? = null

        fun getInstance(context: Context) : EmployeeRoomDatabase {
            //making the instance creation single threaded
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        EmployeeRoomDatabase::class.java,
                        "employee",
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}