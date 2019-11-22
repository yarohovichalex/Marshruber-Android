package com.github.yarohovichalex.marshruber.android.driver

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.yarohovichalex.marshruber.android.common.SchedulerSet
import com.github.yarohovichalex.marshruber.android.ui.driver.driving.DrivingRouteViewModel
import com.github.yarohovichalex.marshruber.android.ui.driver.start.DriverStartRouteViewModel
import timber.log.Timber

class DriverViewModelFactory(
    private val schedulerSet: SchedulerSet
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Timber.d("DriverViewModelFactory:instantiate:$modelClass")
        return when {

            DriverStartRouteViewModel::class.java.isAssignableFrom(modelClass) -> DriverStartRouteViewModel(
                schedulerSet = schedulerSet
            ) as T

            DrivingRouteViewModel::class.java.isAssignableFrom(modelClass) -> DrivingRouteViewModel(
                schedulerSet = schedulerSet
            ) as T

            else -> modelClass.getConstructor().newInstance()
        }
    }
}
