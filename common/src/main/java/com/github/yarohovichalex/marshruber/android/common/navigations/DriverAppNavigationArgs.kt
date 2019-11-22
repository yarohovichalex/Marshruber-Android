package com.github.yarohovichalex.marshruber.android.common.navigations

import android.os.Bundle
import com.github.yarohovichalex.marshruber.android.common.data.DriverData

interface DriverAppNavigationArgs {

    fun createDrivingRouteFragmentArgs(driverData: DriverData): Bundle

    fun getDrivingRouteFragmentArgs(args: Bundle?): DriverData?
}
