package com.github.yarohovichalex.marshruber.android.common

import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RiderData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData

interface MarshruberNetworkApi {

    suspend fun getDriversByRoute(routeId: String): List<DriverData>

    suspend fun getRoutes(): List<RouteData>

    suspend fun getRidersByRoute(routeId: String): List<RiderData>

    suspend fun updateDriver(driver: DriverData): DriverData

    suspend fun updateRider(rider: RiderData): RiderData
}
