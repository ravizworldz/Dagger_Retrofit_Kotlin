package com.demo.dagger2demo_kotlin.di

import com.demo.dagger2demo_kotlin.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)
}