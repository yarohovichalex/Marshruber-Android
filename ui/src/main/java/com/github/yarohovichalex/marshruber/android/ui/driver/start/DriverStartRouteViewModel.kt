package com.github.yarohovichalex.marshruber.android.ui.driver.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.yarohovichalex.marshruber.android.common.MarshruberNetworkApi
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
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

                stateData.postValue(
                    NormalDriverStartRouteState(
                        routeList = routeList,
                        driverName = "driverName",
                        driverPhone = "driverPhone",
                        driverCarNumber = "driverCarNumber"
                    )
                )
            } catch (t: Throwable) {
                stateData.postValue(
                    ErrorDriverStartRouteState(t)
                )
            }
            loadingData.postValue(false)
        }
    }
}
