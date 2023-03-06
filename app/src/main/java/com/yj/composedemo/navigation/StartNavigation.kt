package com.yj.composedemo.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yj.composedemo.navigation.screens.FirstScreen
import com.yj.composedemo.navigation.screens.SecondScreen
import com.yj.composedemo.navigation.utils.NavigationScreenTag

@Composable
fun StartNavigation(context: Context) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationScreenTag.FirstScreen.route
    ) {
        composable(NavigationScreenTag.FirstScreen.route) {
            FirstScreen(navHostController = navController)
        }

        composable(NavigationScreenTag.SecondScreen.route) {
            val data = it.arguments?.getString("data")
            SecondScreen(context = context, data!!)
        }
    }
}