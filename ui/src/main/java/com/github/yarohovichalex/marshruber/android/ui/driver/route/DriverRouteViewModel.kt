package com.github.yarohovichalex.marshruber.android.ui.driver.route

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.yarohovichalex.marshruber.android.common.MarshruberNetworkApi
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData
import com.github.yarohovichalex.marshruber.android.ui.common.BaseViewModel
import kotlinx.coroutines.launch

class DriverRouteViewModel(
    private val schedulerSet: SchedulerSet,
    private val marshruberNetworkApi: MarshruberNetworkApi
) : BaseViewModel() {
    val stateData = MutableLiveData<DriverRouteState>()

    val loadingData = MutableLiveData<Boolean>()

    fun requestData() {
        viewModelScope.launch(schedulerSet.ioCoroutineContext) {
            try {
                val routeList: List<RouteData> = try {
                    marshruberNetworkApi.getRoutes()
                } catch (t: Throwable) {
                    emptyList()
                }

                stateData.postValue(
                    NormalDriverRouteState(
                        routeList = routeList
                    )
                )
            } catch (t: Throwable) {
                stateData.postValue(ErrorDriverRouteState(t))
            }
            loadingData.postValue(false)
        }
    }

    fun driverStartRoute(
        driverData: DriverData,
        resultCallback: (DriverData) -> Unit
    ) {
        viewModelScope.launch(schedulerSet.ioCoroutineContext) {
            try {
                val responseDriverData: DriverData = marshruberNetworkApi.updateDriver(driverData)
                viewModelScope.launch(schedulerSet.uiCoroutineContext) {
                    resultCallback(responseDriverData)
                }
            } catch (t: Throwable) {
                stateData.postValue(ErrorDriverRouteState(t))
            }
        }
    }
}
