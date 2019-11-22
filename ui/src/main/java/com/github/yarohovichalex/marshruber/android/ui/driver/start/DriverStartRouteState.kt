package com.github.yarohovichalex.marshruber.android.ui.driver.start

import com.github.yarohovichalex.marshruber.android.common.data.RouteData

sealed class DriverStartRouteState

data class NormalDriverStartRouteState(
    val routeList: List<RouteData>,
    val driverName: String?,
    val driverPhone: String?,
    val driverCarNumber: String?
) : DriverStartRouteState()

data class ErrorDriverStartRouteState(val error: Throwable) : DriverStartRouteState()
