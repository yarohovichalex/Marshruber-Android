package com.github.yarohovichalex.marshruber.android.common

import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RiderData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData

interface MarshruberNetworkApi {
    suspend fun getDriversByRoute(routeName: String): List<DriverData>

    suspend fun getRoutes(): List<RouteData>

    suspend fun getRidersByRoute(routeId: String): List<RiderData>

    suspend fun startRouteForDriver(driver: DriverData): DriverData

    suspend fun startRouteForRider(rider: RiderData): RiderData

    suspend fun finishRouteForDriver(driverId: String): DriverData

    suspend fun finishRouteForRider(riderId: String): RiderData
//    suspend fun getClientByPhoneNumber(phoneNumber: String): RiderData
//
//    suspend fun sendClientInfo()
}
