package com.yj.composedemo.navigation.screens

import android.content.Context
import android.content.Intent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.yj.composedemo.OnBoardActivity

@Composable
fun SecondScreen(context: Context, data: String) {
    Button(onClick = {
        val intent = Intent(context, OnBoardActivity::class.java)
        context.startActivity(intent)
    }) {
        Text(text = "Hello $data")
    }
}