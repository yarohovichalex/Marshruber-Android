package com.github.yarohovichalex.marshruber.android.ui.driver.driving

import androidx.lifecycle.LiveData

interface DrivingRoutePresenter {
    fun getStateData(): LiveData<DrivingRouteState>
    fun getLoadingData(): LiveData<Boolean>
    fun requestData()
}
