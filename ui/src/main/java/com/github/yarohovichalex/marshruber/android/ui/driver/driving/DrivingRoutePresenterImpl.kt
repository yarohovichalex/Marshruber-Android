package com.github.yarohovichalex.marshruber.android.ui.driver.driving

import androidx.lifecycle.LiveData
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.navigations.DriverAppNavigation

class DrivingRoutePresenterImpl(
    private val driverData: DriverData?,
    private val drivingRouteViewModel: DrivingRouteViewModel,
    private val driverAppNavigation: DriverAppNavigation
) : DrivingRoutePresenter {
    override fun getStateData(): LiveData<DrivingRouteState> =
        drivingRouteViewModel.stateData

    override fun getLoadingData(): LiveData<Boolean> =
        drivingRouteViewModel.loadingData

    override fun requestData() =
        drivingRouteViewModel.requestData(driverData?.route)

    override fun finishRoute() {
        driverAppNavigation.navigateToDriver()
    }
}
