package com.github.yarohovichalex.marshruber.android.ui.driver.route

import com.github.yarohovichalex.marshruber.android.common.data.RouteData

sealed class DriverRouteState

data class NormalDriverRouteState(val routeList: List<RouteData>) : DriverRouteState()

data class ErrorDriverRouteState(val error: Throwable) : DriverRouteState()
