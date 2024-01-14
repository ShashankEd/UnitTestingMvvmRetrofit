package com.shashank.unittestingdemo

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import com.google.common.truth.Truth.assertThat
import com.shashank.unittestingdemo.core.utils.Validator

@RunWith(JUnit4::class)
class ValidatorTest {

    @Test
    fun whenInputIsValid() {
        val amount = 100
        val desc = "Test"
        val result = Validator.validateInput(amount,desc)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun whenInputIsInvalid() {
        val amount = 0
        val desc = ""
        val result = Validator.validateInput(amount,desc)
        assertThat(result).isEqualTo(false)
    }

}