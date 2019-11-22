package com.github.yarohovichalex.marshruber.android.rider

import android.app.Application
import timber.log.Timber

class RiderApplication : Application() {

    val riderModules: RiderModules by lazy { RiderModules(this) }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
