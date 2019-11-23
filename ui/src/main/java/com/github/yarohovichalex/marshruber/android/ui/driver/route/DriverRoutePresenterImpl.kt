package com.github.yarohovichalex.marshruber.android.ui.driver.route

import androidx.lifecycle.LiveData
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData
import com.github.yarohovichalex.marshruber.android.common.navigations.DriverAppNavigation

class DriverRoutePresenterImpl(
    private val driverData: DriverData?,
    private val driverRouteViewModel: DriverRouteViewModel,
    private val driverAppNavigation: DriverAppNavigation
) : DriverRoutePresenter {

    override fun getStateData(): LiveData<DriverRouteState> =
        driverRouteViewModel.stateData

    override fun getLoadingData(): LiveData<Boolean> =
        driverRouteViewModel.loadingData

    override fun requestData() =
        driverRouteViewModel.requestData()

    override fun driverStartRoute(route: RouteData) {
        driverData?.copy(route = route)?.let {
            driverRouteViewModel.driverStartRoute(it) { driver ->
                driverAppNavigation.navigateToRiderList(driver)
            }
        }
    }
}
