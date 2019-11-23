package com.github.yarohovichalex.marshruber.android.ui.driver.route

import androidx.lifecycle.LiveData

interface DriverRoutePresenter {
    fun getStateData(): LiveData<DriverRouteState>
    fun getLoadingData(): LiveData<Boolean>
    fun requestData()
    fun driverStartRoute()
}
