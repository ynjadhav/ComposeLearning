package com.yj.composedemo.utils

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class HelperTest {

    lateinit var helper: Helper

    @Before
    fun setUp(){
        println("Before each test case")
        helper = Helper()
    }

    @After
    fun tearDown(){
        println("After each test case")
    }

    @Test
    fun isPalindrome() {

        //step 1. Arrange
//         val helper = Helper()

        //step 2. Act
        val result = helper.isPalindrome("Android")

        //step 3. Assert
        assertEquals(false,result)
    }

    @Test
    fun isPalindrome_inputString_level_expectedTrue() {

        //step 1. Arrange
//         val helper = Helper()

        //step 2. Act
        val result = helper.isPalindrome("level")

        //step 3. Assert
        assertEquals(true,result)
    }
}