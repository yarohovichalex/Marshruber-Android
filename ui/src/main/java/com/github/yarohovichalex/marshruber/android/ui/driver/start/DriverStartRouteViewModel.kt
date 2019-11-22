package com.github.yarohovichalex.marshruber.android.ui.driver.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
import com.github.yarohovichalex.marshruber.android.common.data.RouteData
import com.github.yarohovichalex.marshruber.android.ui.common.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DriverStartRouteViewModel(
    private val schedulerSet: SchedulerSet
) : BaseViewModel() {

    val stateData = MutableLiveData<DriverStartRouteState>()

    val loadingData = MutableLiveData<Boolean>()

    fun requestData() {
        viewModelScope.launch(schedulerSet.ioCoroutineContext) {
            delay(3000)
            stateData.postValue(NormalDriverStartRouteState(
                    routeList = listOf(
                            RouteData(
                                    routeId = "routeId1",
                                    name = "name1"
                            ),
                            RouteData(
                                    routeId = "routeId2",
                                    name = "name2"
                            )
                    ),
                    driverName = "driverName",
                    driverPhone = "driverPhone",
                    driverCarNumber = "driverCarNumber"
            ))
            loadingData.postValue(false)
        }
    }
}
