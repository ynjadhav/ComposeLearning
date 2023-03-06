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

@AndroidEntryPoint
class PostsActivity : ComponentActivity() {

    private val postViewModel: PostViewModel by viewModels()

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ComposeDemoTheme() {
                Surface(color = MaterialTheme.colors.background) {
                    GetPostsData(postViewModel)
//                    OnBoardScreen()
                }
            }
        }

    }

    @Composable
    fun GetPostsData(postViewModel: PostViewModel) {

        when (val result = postViewModel.response.value) {

            is ApiState.Success -> {
//                LazyColumn() {
//                    items(result.data) {
//                        EachRow(post = it)
//                    }
//                }
                ShowPosts(result.data)
            }

            is ApiState.Failure -> {
                Text(text = "${result.msg}")
            }

            is ApiState.Loading -> {

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(40.dp),
                        color = MaterialTheme.colors.primaryVariant
                    )

                }
            }

            is ApiState.Empty -> {

            }
        }
    }

    @Composable
    fun ShowPosts(posts: List<Post>) {
        LazyColumn() {
            posts.map {
                item {
                    EachRow(post = it)
                }
            }
        }
    }

    @Composable
    fun EachRow(post: Post) {
        Card(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(5.dp),
            elevation = 2.dp
        ) {
            Text(text = post.body)
        }
    }
}