package com.github.yarohovichalex.marshruber.android.driver

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.github.yarohovichalex.marshruber.android.common.DefaultSchedulerSet
import com.github.yarohovichalex.marshruber.android.common.MarshruberNetworkApi
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
import com.github.yarohovichalex.marshruber.android.common.navigations.DriverAppNavigationArgs
import com.github.yarohovichalex.marshruber.android.navigation.driver.JetpackDriverAppNavigationArgs
import com.github.yarohovichalex.marshruber.android.network.retrofit.MarshruberRestService
import com.github.yarohovichalex.marshruber.android.network.retrofit.RetrofitBuilder
import com.github.yarohovichalex.marshruber.android.network.retrofit.RetrofitMarshruberNetworkApi

class DriverModules(application: Application) {

    val context: Context = application.applicationContext

    val schedulerSet: SchedulerSet by lazy { DefaultSchedulerSet() }
    val driverAppNavigationArgs: DriverAppNavigationArgs by lazy { JetpackDriverAppNavigationArgs() }

    val marshruberRestService: MarshruberRestService by lazy { RetrofitBuilder.buildMarshruberRestService() }
    val marshruberNetworkApi: MarshruberNetworkApi by lazy {
        RetrofitMarshruberNetworkApi(
            marshruberRestService = marshruberRestService
        )
    }

    val viewModelFactory: ViewModelProvider.Factory by lazy {
        DriverViewModelFactory(
            schedulerSet = schedulerSet,
            marshruberNetworkApi = marshruberNetworkApi
        )
    }
}
