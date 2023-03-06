package com.yj.composedemo.utils

class Helper {

    fun isPalindrome(input: String): Boolean {
        var i = 0
        var j = input.length - 1
        var result = true

        while (i < j) {
            if (input[i] != input[j]) {
                result = false
                break
            }
            i++
            j--
        }

        return result
    }

    fun validatePassword(input: String) = when {

        input.isEmpty() -> {
            "Password is required"
        }

        input.length < 6 -> {
            "Password is should have 6 Characters"
        }

        input.length > 15 -> {
            "Password is should not have greater than 15 Characters"
        }

        else -> {
            "Valid Password"
        }
    }

    fun reverseString(input: String?): String {

        if (input == null) {
            throw IllegalArgumentException("Argument is required")
        }

        val chars = input.toCharArray()
        var i = 0
        var j = input.length - 1

        while (i < j) {

            val temp = chars[i]
            chars[i] = chars[j]
            chars[j] = temp

            i++
            j--
        }

        return chars.joinToString("")
    }
}