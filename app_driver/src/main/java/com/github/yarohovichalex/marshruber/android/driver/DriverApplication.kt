package com.github.yarohovichalex.marshruber.android.driver

import android.app.Application
import timber.log.Timber

class DriverApplication : Application() {

    val driverModules: DriverModules by lazy { DriverModules(this) }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
