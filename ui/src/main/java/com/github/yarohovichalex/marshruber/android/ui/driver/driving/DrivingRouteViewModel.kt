package com.github.yarohovichalex.marshruber.android.ui.driver.driving

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.yarohovichalex.marshruber.android.common.MarshruberNetworkApi
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
import com.github.yarohovichalex.marshruber.android.common.data.RouteData
import com.github.yarohovichalex.marshruber.android.ui.common.BaseViewModel
import kotlinx.coroutines.launch

class DrivingRouteViewModel(
    private val schedulerSet: SchedulerSet,
    private val marshruberNetworkApi: MarshruberNetworkApi
) : BaseViewModel() {

    val stateData = MutableLiveData<DrivingRouteState>()

    val loadingData = MutableLiveData<Boolean>()

    fun requestData(route: RouteData?) {
        viewModelScope.launch(schedulerSet.ioCoroutineContext) {
            try {
                val riderList = marshruberNetworkApi.getRidersByRoute(route?.routeId)
                stateData.postValue(
                    NormalDrivingRouteState(riderList = riderList)
                )
            } catch (t: Throwable) {
                stateData.postValue(ErrorDrivingRouteState(t))
            }
            loadingData.postValue(false)
        }
    }
}
