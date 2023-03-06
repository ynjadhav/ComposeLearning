package com.yj.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.yj.composedemo.navigation.StartNavigation
import com.yj.composedemo.ui.theme.ComposeDemoTheme

class NavigationActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ComposeDemoTheme() {
                Surface() {
                    StartNavigation(context = this)
                }
            }
        }
    }
}