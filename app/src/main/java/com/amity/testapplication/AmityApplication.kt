package com.amity.testapplication

import android.app.Application
import com.amity.testapplication.core.initializer.TimberInitializer
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class annotated with DI HILT
 */
@HiltAndroidApp
class AmityApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        TimberInitializer().create(this)
    }
}