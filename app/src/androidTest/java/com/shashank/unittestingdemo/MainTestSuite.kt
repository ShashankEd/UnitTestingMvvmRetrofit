package com.shashank.unittestingdemo

import com.shashank.unittestingdemo.api.ApiIsolationTest
import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.junit.runners.Suite.SuiteClasses

@RunWith(Suite::class)
@SuiteClasses(
    ApiIsolationTest::class
)
class MainTestSuite
