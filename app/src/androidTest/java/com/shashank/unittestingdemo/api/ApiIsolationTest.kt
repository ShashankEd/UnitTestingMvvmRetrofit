package com.shashank.unittestingdemo.api

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ApiIsolationTest: TestCase() {

    @Test
    fun testEmployeeApiSuccess() {
        val api = TestEmployeeApiImplementation().provideApi()
        val test = runBlocking {
            api.getEmployees()
        }

        assertEquals(test.status, "success")

    }

    @Test
    fun testEmployeeApiSuccessNotEmpty() {
        val api = TestEmployeeApiImplementation().provideApi()
        val test = runBlocking {
            api.getEmployees()
        }

        assertEquals(test.data.isNotEmpty(), true)

    }

    @Test
    fun testEmployeeApiFailed() {
        val api = TestEmployeeApiImplementation().provideApi()
        val test = runBlocking {
            api.getEmployees()
        }

        assertEquals(test.status, "failure")

    }
}