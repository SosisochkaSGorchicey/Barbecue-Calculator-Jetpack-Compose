package com.my.shashlik.di

import android.app.Application
import com.my.shashlik.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApp)
            androidLogger()
            modules(
                listOf(
                    PresentationModule()
                )
            )
        }
    }
}