package com.github.yarohovichalex.marshruber.android.network

import com.github.yarohovichalex.marshruber.android.common.MarshruberNetworkApi
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RiderData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData
import com.squareup.moshi.Moshi

class StubMarshruberNetworkApi(
    private val moshi: Moshi
) : MarshruberNetworkApi {

    private val routeList: List<RouteData> = mutableListOf(
        RouteData(
            routeId = "routeId1",
            name = "МАРШРУТ ТУДЫ"
        ),
        RouteData(
            routeId = "routeId2",
            name = "маршрут сюды"
        )
    )

    private val driverList: List<DriverData> = mutableListOf(
        DriverData(
            driverId = "driverId1",
            name = "Гонщик",
            phone = "+735 F1 111-11-11",
            carNumber = "1111 FI 1",
            route = routeList.firstOrNull()
        ),
        DriverData(
            driverId = "driverId2",
            name = "Шустрик",
            phone = "+735 R2 222-22-22",
            carNumber = "2222 RD 1",
            route = null
        )
    )

    private val riderList: List<RiderData> = mutableListOf(
        RiderData(
            riderId = "riderId1",
            name = "Студент",
            phone = "+735 29 999-99-99",
            route = routeList.getOrNull(0)
        ),
        RiderData(
            riderId = "riderId2",
            name = "Петя",
            phone = "+735 29 888-88-88",
            route = routeList.getOrNull(1)
        ),
        RiderData(
            riderId = "riderId3",
            name = "Коля",
            phone = "+735 29 777-77-77",
            route = routeList.getOrNull(1)
        )
    )

    override suspend fun getDriversByRoute(routeId: String?): List<DriverData> =
        driverList.filter { it.route?.routeId == routeId }

    override suspend fun getRoutes(): List<RouteData> =
        routeList

    override suspend fun getRidersByRoute(routeId: String?): List<RiderData> =
        riderList.filter { it.route?.routeId == routeId }

    override suspend fun updateDriver(driver: DriverData): DriverData =
        driver

    override suspend fun updateRider(rider: RiderData): RiderData =
        rider
}
