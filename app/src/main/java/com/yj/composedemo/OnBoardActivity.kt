package com.yj.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.yj.composedemo.retrofit.Post
import com.yj.composedemo.retrofit.ui.PostViewModel
import com.yj.composedemo.retrofit.utils.ApiState
import com.yj.composedemo.ui.theme.ComposeDemoTheme
import com.yj.composedemo.viewpager.OnBoardScreen
import dagger.hilt.android.AndroidEntryPoint

class OnBoardActivity : ComponentActivity() {

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ComposeDemoTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    OnBoardScreen()
                }
            }
        }

    }
}