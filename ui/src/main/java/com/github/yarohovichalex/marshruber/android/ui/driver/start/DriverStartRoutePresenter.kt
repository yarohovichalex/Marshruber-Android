package com.github.yarohovichalex.marshruber.android.ui.driver.start

import androidx.lifecycle.LiveData

interface DriverStartRoutePresenter {
    fun getStateData(): LiveData<DriverStartRouteState>
    fun getLoadingData(): LiveData<Boolean>
    fun requestData()
}
