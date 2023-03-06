package com.yj.composedemo.viewpager


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@ExperimentalPagerApi
@Composable
fun OnBoardScreen() {

    val pagerState = rememberPagerState()

    Column {

        HorizontalPager(
            count = dataList.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) { page ->
            PageUi(pager = dataList[page])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(4.dp),
            activeColor = MaterialTheme.colors.primary
        )

        AnimatedVisibility(visible = pagerState.currentPage == 2) {

            OutlinedButton(onClick = { }, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Getting Started")
            }
        }

    }
}


@Composable
fun PageUi(pager: PagerData) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = pager.id),
            contentDescription = pager.desc,
            modifier = Modifier.size(200.dp)
        )

        Spacer(modifier = Modifier.size(20.dp))

        Text(text = pager.desc)
    }
}