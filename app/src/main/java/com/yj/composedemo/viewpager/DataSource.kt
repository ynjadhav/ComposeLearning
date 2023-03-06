package com.yj.composedemo.viewpager

import androidx.annotation.DrawableRes
import com.yj.composedemo.R

data class PagerData(
    @DrawableRes val id: Int,
    val desc: String
)

val dataList = listOf(
    PagerData(R.drawable.ic_launcher_background, "Page One"),
    PagerData(R.drawable.ic_launcher_background, "Page Two"),
    PagerData(R.drawable.ic_launcher_background, "Page Three")
)