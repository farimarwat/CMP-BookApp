package com.farimarwat.bookapp

import android.app.Application
import com.farimarwat.bookapp.di.initKoin
import com.farimarwat.bookapp.di.platformModule
import com.farimarwat.bookapp.di.sharedModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BaseApplication)
        }
    }
}