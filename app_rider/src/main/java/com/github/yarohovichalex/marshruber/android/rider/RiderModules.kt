package com.github.yarohovichalex.marshruber.android.rider

import android.app.Application
import android.content.Context
import com.github.yarohovichalex.marshruber.android.common.DefaultSchedulerSet
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
import com.github.yarohovichalex.marshruber.android.common.navigations.RiderAppNavigationArgs
import com.github.yarohovichalex.marshruber.android.navigation.rider.JetpackRiderAppNavigationArgs

class RiderModules(application: Application) {

    val context: Context = application.applicationContext

    val schedulerSet: SchedulerSet by lazy { DefaultSchedulerSet() }
    val riderAppNavigationArgs: RiderAppNavigationArgs by lazy { JetpackRiderAppNavigationArgs() }
}
