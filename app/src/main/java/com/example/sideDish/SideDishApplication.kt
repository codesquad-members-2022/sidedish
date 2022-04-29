package com.example.sideDish

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SideDishApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}