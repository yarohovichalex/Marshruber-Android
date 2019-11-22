package com.github.yarohovichalex.marshruber.android.driver

import android.app.Application
import timber.log.Timber

class DriverAppApplication : Application() {

    val driverAppModules: DriverAppModules by lazy { DriverAppModules(this) }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
