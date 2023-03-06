package com.yj.composedemo.retrofit.utils

import com.yj.composedemo.retrofit.Post

sealed class ApiState {

    class Success(val data: List<Post>) : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    object Loading : ApiState()
    object Empty : ApiState()

}
