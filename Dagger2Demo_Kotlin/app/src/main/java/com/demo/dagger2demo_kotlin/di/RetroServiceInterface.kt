package com.demo.dagger2demo_kotlin.di

import com.demo.dagger2demo_kotlin.model.RecyclerList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

    @GET("repositories")
    fun getDataFromAPI(@Query("q")query: String): Call<RecyclerList>?
}