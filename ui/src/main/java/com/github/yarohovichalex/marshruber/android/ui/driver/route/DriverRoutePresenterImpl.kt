package com.github.yarohovichalex.marshruber.android.ui.driver.route

import androidx.lifecycle.LiveData
import com.github.yarohovichalex.marshruber.android.common.navigations.DriverAppNavigation

class DriverRoutePresenterImpl(
    private val driverRouteViewModel: DriverRouteViewModel,
    private val driverAppNavigation: DriverAppNavigation
) : DriverRoutePresenter {

    override fun getStateData(): LiveData<DriverRouteState> =
        driverRouteViewModel.stateData

    override fun getLoadingData(): LiveData<Boolean> =
        driverRouteViewModel.loadingData

    override fun requestData() =
        driverRouteViewModel.requestData()

    override fun driverStartRoute() {
        driverRouteViewModel.driverStartRoute(
            driverName = "",
            driverPhone = "",
            driverCarNumber = ""
        ) { driver ->
            driverAppNavigation.navigateToDrivingRoute(driver)
        }
    }
}
