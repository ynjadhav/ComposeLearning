package com.yj.composedemo.navigation.utils

sealed class NavigationScreenTag(val route: String) {

    object FirstScreen : NavigationScreenTag("FirstScreen")
    object SecondScreen : NavigationScreenTag("{data}/SecondScreen"){
        fun createRoute(data:String) = "$data/SecondScreen"
    }
}
