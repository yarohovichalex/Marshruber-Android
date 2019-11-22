package com.github.yarohovichalex.marshruber.android.ui.driver.driving

import com.github.yarohovichalex.marshruber.android.common.data.RiderData

sealed class DrivingRouteState

data class NormalDrivingRouteState(val riderList: List<RiderData>) : DrivingRouteState()

data class ErrorDrivingRouteState(val error: Throwable) : DrivingRouteState()
