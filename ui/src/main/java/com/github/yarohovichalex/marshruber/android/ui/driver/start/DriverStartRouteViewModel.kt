package com.github.yarohovichalex.marshruber.android.ui.driver.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.yarohovichalex.marshruber.android.common.MarshruberNetworkApi
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData
import com.github.yarohovichalex.marshruber.android.ui.common.BaseViewModel
import kotlinx.coroutines.launch

class DriverStartRouteViewModel(
    private val schedulerSet: SchedulerSet,
    private val marshruberNetworkApi: MarshruberNetworkApi
) : BaseViewModel() {

    val stateData = MutableLiveData<DriverStartRouteState>()

    val loadingData = MutableLiveData<Boolean>()

    fun requestData() {
        viewModelScope.launch(schedulerSet.ioCoroutineContext) {
            try {
                val routeList: List<RouteData> = try {
                    marshruberNetworkApi.getRoutes()
                } catch (t: Throwable) {
                    emptyList()
                }

                val driver = marshruberNetworkApi.getDriversByRoute(
                    routeList.firstOrNull()?.routeId
                )
                    .firstOrNull()

                stateData.postValue(
                    NormalDriverStartRouteState(
                        routeList = routeList,
                        driverName = driver?.name,
                        driverPhone = driver?.phone,
                        driverCarNumber = driver?.carNumber
                    )
                )
            } catch (t: Throwable) {
                stateData.postValue(ErrorDriverStartRouteState(t))
            }
            loadingData.postValue(false)
        }
    }

    fun driverStartRoute(
        driverName: String,
        driverPhone: String,
        driverCarNumber: String,
        resultCallback: (DriverData) -> Unit
    ) {
        viewModelScope.launch(schedulerSet.ioCoroutineContext) {
            try {
                val driverData: DriverData = marshruberNetworkApi.updateDriver(
                    DriverData(
                        driverId = null,
                        name = driverName,
                        phone = driverPhone,
                        carNumber = driverCarNumber,
                        route = null
                    )
                )

                viewModelScope.launch(schedulerSet.uiCoroutineContext) {
                    resultCallback(driverData)
                }
            } catch (t: Throwable) {
                stateData.postValue(ErrorDriverStartRouteState(t))
            }
        }
    }
}
