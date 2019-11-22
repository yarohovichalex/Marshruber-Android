package com.github.yarohovichalex.marshruber.android.ui.driver.start

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
import com.github.yarohovichalex.marshruber.android.ui.common.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DriverStartRouteViewModel(
    private val schedulerSet: SchedulerSet
) : BaseViewModel() {

    val stateData = MutableLiveData<DriverStartRouteState>()
            .apply {
                postValue(NormalDriverStartRouteState(emptyList()))
            }

    val loadingData = MutableLiveData<Boolean>()

    fun requestData() {
        viewModelScope.launch(schedulerSet.ioCoroutineContext) {
            delay(3000)
            stateData.postValue(ErrorDriverStartRouteState(Error("Test error")))
            loadingData.postValue(false)
        }
    }
}
