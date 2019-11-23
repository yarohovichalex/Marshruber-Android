package com.github.yarohovichalex.marshruber.android.ui.driver.route

import androidx.lifecycle.LiveData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData

interface DriverRoutePresenter {
    fun getStateData(): LiveData<DriverRouteState>
    fun getLoadingData(): LiveData<Boolean>
    fun requestData()
    fun driverStartRoute(route: RouteData)
}
