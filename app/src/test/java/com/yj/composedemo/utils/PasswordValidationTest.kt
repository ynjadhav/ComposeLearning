package com.yj.composedemo.utils

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class PasswordValidationTest(private val input: String, private val expected: String) {

    @Test
    fun test() {
        val helper = Helper()
        val result = helper.validatePassword(input)
        Assert.assertEquals(expected, result)
    }

    companion object{

        @JvmStatic
        @Parameterized.Parameters(name = "{index} -> Input-{0}, Expected-{1}")
        fun data() : List<Array<Any>>{
            return listOf(
                arrayOf("","Password is required"),
                arrayOf("a1","Password is should have 6 Characters"),
                arrayOf("bhjbchjbcjhbhchbb2b12b3b23hbjb3321","Password is should not have greater than 15 Characters"),
                arrayOf("Pass123","Valid Password"),
            )
        }
    }

}