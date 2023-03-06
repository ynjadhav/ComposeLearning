package com.yj.composedemo.navigation.screens

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.yj.composedemo.navigation.utils.NavigationScreenTag

@Composable
fun FirstScreen(navHostController: NavHostController) {
    Button(onClick = {
        navHostController.navigate(NavigationScreenTag.SecondScreen.createRoute("Yo!"))
    }) {
        Text(text = "Click me")
    }
}