package com.github.yarohovichalex.marshruber.android.ui.driver.start

import androidx.lifecycle.LiveData
import com.github.yarohovichalex.marshruber.android.common.navigations.DriverAppNavigation

class DriverStartRoutePresenterImpl(
    private val driverStartRouteViewModel: DriverStartRouteViewModel,
    private val driverAppNavigation: DriverAppNavigation
) : DriverStartRoutePresenter {

    override fun getStateData(): LiveData<DriverStartRouteState> =
        driverStartRouteViewModel.stateData

    override fun getLoadingData(): LiveData<Boolean> =
        driverStartRouteViewModel.loadingData

    override fun requestData() =
        driverStartRouteViewModel.requestData()

    override fun driverStartRoute(
        driverName: String,
        driverPhone: String,
        driverCarNumber: String
    ) {
        driverStartRouteViewModel.driverStartRoute(
            driverName = driverName,
            driverPhone = driverPhone,
            driverCarNumber = driverCarNumber
        ) { driver ->
            driverAppNavigation.navigateToRouteList(driver)
        }
    }
}
