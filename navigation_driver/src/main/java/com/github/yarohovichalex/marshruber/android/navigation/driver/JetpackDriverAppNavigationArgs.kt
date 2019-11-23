package com.github.yarohovichalex.marshruber.android.navigation.driver

import android.os.Bundle
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.navigations.DriverAppNavigationArgs
import com.github.yarohovichalex.marshruber.android.ui.driver.driving.DrivingRouteFragmentArgs
import com.github.yarohovichalex.marshruber.android.ui.driver.start.DriverStartRouteFragmentDirections

class JetpackDriverAppNavigationArgs : DriverAppNavigationArgs {

    override fun createDrivingRouteFragmentArgs(driverData: DriverData): Bundle =
        DriverStartRouteFragmentDirections.actionDriverToRouteList(driver = driverData).arguments

    override fun getDrivingRouteFragmentArgs(args: Bundle?): DriverData? =
        args?.let { DrivingRouteFragmentArgs.fromBundle(it).driver }
}
