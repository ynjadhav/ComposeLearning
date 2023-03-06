package com.yj.composedemo.retrofit.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.yj.composedemo.retrofit.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //Using Moshi Converter
    /*

    @Provides
    @Singleton
    fun providesMoshi(): Moshi = Moshi
        .Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    @Singleton
    fun providesApiService(moshi: Moshi): ApiService = Retrofit.Builder().run {
        baseUrl(ApiService.BASE_URL)
        addConverterFactory(MoshiConverterFactory.create(moshi))
        build()
    }.create(ApiService::class.java)

    */


    //Using Gson Converter
    @Provides
    @Singleton
    fun provideGson():Gson = GsonBuilder()
        .setLenient()
        .disableHtmlEscaping()
        .create()

    @Provides
    @Singleton
    fun providesApiService(gson: Gson): ApiService = Retrofit.Builder().run {
        baseUrl(ApiService.BASE_URL)
        addConverterFactory(GsonConverterFactory.create(gson))
        build()
    }.create(ApiService::class.java)
}