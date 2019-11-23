package com.github.yarohovichalex.marshruber.android.ui.driver.start

import androidx.lifecycle.LiveData
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData
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
        route: RouteData,
        driverName: String?,
        driverPhone: String?,
        driverCarNumber: String?
    ) {
        driverAppNavigation.navigateToDrivingRoute(
            DriverData(
                driverId = "driverId",
                name = "name",
                phone = "phone",
                carNumber = "carNumber",
                route = route
            )
        )
    }
}
