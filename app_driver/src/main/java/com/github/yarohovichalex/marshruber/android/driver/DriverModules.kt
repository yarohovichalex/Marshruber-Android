package com.github.yarohovichalex.marshruber.android.driver

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.github.yarohovichalex.marshruber.android.common.DefaultSchedulerSet
import com.github.yarohovichalex.marshruber.android.common.MarshruberNetworkApi
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
import com.github.yarohovichalex.marshruber.android.common.navigations.DriverAppNavigationArgs
import com.github.yarohovichalex.marshruber.android.navigation.driver.JetpackDriverAppNavigationArgs
import com.github.yarohovichalex.marshruber.android.network.StubMarshruberNetworkApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class DriverModules(application: Application) {

    val context: Context = application.applicationContext

    val schedulerSet: SchedulerSet by lazy { DefaultSchedulerSet() }
    val driverAppNavigationArgs: DriverAppNavigationArgs by lazy { JetpackDriverAppNavigationArgs() }

    val moshi: Moshi by lazy {
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
    //    val marshruberRestService: MarshruberRestService by lazy { RetrofitBuilder.buildMarshruberRestService(moshi) }
//    val marshruberNetworkApi: MarshruberNetworkApi by lazy {
//        RetrofitMarshruberNetworkApi(
//            marshruberRestService = marshruberRestService
//        )
//    }
    val marshruberNetworkApi: MarshruberNetworkApi by lazy { StubMarshruberNetworkApi(moshi) }

    val viewModelFactory: ViewModelProvider.Factory by lazy {
        DriverViewModelFactory(
            schedulerSet = schedulerSet,
            marshruberNetworkApi = marshruberNetworkApi
        )
    }
}
