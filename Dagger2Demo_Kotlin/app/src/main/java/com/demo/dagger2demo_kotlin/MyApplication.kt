package com.demo.dagger2demo_kotlin

import android.app.Application
import com.demo.dagger2demo_kotlin.di.DaggerRetroComponent
import com.demo.dagger2demo_kotlin.di.RetroComponent
import com.demo.dagger2demo_kotlin.di.RetroModule

class MyApplication: Application() {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()

        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getRetroComponent(): RetroComponent {
        return retroComponent
    }
}