package com.github.yarohovichalex.marshruber.android.driver

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.github.yarohovichalex.marshruber.android.common.DefaultSchedulerSet
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
import com.github.yarohovichalex.marshruber.android.common.navigations.DriverAppNavigationArgs
import com.github.yarohovichalex.marshruber.android.navigation.driver.JetpackDriverAppNavigationArgs

class DriverModules(application: Application) {

    val context: Context = application.applicationContext

    val schedulerSet: SchedulerSet by lazy { DefaultSchedulerSet() }
    val driverAppNavigationArgs: DriverAppNavigationArgs by lazy { JetpackDriverAppNavigationArgs() }

    val viewModelFactory: ViewModelProvider.Factory by lazy {
        DriverViewModelFactory(
                schedulerSet = schedulerSet
        )
    }
}
