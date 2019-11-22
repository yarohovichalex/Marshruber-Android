package com.github.yarohovichalex.marshruber.android.ui.driver.driving

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
import com.github.yarohovichalex.marshruber.android.common.data.RiderData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData
import com.github.yarohovichalex.marshruber.android.ui.common.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DrivingRouteViewModel(
    private val schedulerSet: SchedulerSet
) : BaseViewModel() {

    val stateData = MutableLiveData<DrivingRouteState>()

    val loadingData = MutableLiveData<Boolean>()

    fun requestData(route: RouteData) {
        viewModelScope.launch(schedulerSet.ioCoroutineContext) {
            delay(3000)
            stateData.postValue(NormalDrivingRouteState(
                    riderList = listOf(
                            RiderData(
                                    riderId = "routeId1",
                                    name = "name1",
                                    phone = "phone1",
                                    route = route
                            ),
                            RiderData(
                                    riderId = "routeId2",
                                    name = "name2",
                                    phone = "phone2",
                                    route = route
                            )
                    )
            ))
            loadingData.postValue(false)
        }
    }
}
