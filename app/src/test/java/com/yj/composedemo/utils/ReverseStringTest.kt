package com.yj.composedemo.utils

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(value = Parameterized::class)
class ReverseStringTest(private val input: String, private val expected: String) {

    @Test
    fun test() {
        val helper = Helper()
        val result = helper.reverseString(input)
        Assert.assertEquals(expected, result)
    }

    companion object{

        @JvmStatic
        @Parameterized.Parameters(name = "{index} -> Input-{0}, Expected-{1}")
        fun data():List<Array<Any?>?>{

            return listOf(
//                arrayOf(null,"Argument is required"),
                arrayOf("",""),
                arrayOf("a","a"),
                arrayOf("Android","diordnA"),
            )
        }
    }

//    @Test(expected = IllegalArgumentException::class)
//    fun testStringReversal_NullValue_expectedException(){
//        val helper = Helper()
//        val result = helper.reverseString(null)
//    }

}