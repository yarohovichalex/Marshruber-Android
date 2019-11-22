package com.github.yarohovichalex.marshruber.android.ui.driver.start

import com.github.yarohovichalex.marshruber.android.common.data.RouteData

sealed class DriverStartRouteState

data class NormalDriverStartRouteState(val routeList: List<RouteData>) : DriverStartRouteState()

data class ErrorDriverStartRouteState(val error: Throwable) : DriverStartRouteState()
