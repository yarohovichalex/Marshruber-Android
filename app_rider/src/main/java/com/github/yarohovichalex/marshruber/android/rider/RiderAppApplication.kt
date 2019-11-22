package com.github.yarohovichalex.marshruber.android.rider

import android.app.Application
import timber.log.Timber

class RiderAppApplication : Application() {

    val riderAppModules: RiderAppModules by lazy { RiderAppModules(this) }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
