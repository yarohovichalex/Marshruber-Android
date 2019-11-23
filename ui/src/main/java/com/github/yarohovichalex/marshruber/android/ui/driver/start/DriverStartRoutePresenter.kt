package com.github.yarohovichalex.marshruber.android.ui.driver.start

import androidx.lifecycle.LiveData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData

interface DriverStartRoutePresenter {
    fun getStateData(): LiveData<DriverStartRouteState>
    fun getLoadingData(): LiveData<Boolean>
    fun requestData()
    fun driverStartRoute(
        route: RouteData,
        driverName: String,
        driverPhone: String,
        driverCarNumber: String
    )
}
