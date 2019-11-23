package com.github.yarohovichalex.marshruber.android.network

import com.github.yarohovichalex.marshruber.android.common.MarshruberNetworkApi
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RiderData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData

class StubMarshruberNetworkApi : MarshruberNetworkApi {
    override suspend fun getDriversByRoute(routeId: String): List<DriverData> =
        listOf(
            DriverData(
                driverId = "driverId1",
                name = "name1",
                phone = "phone1",
                carNumber = "carNumber1",
                route = RouteData(
                    routeId = routeId,
                    name = "name"
                )
            ),
            DriverData(
                driverId = "driverId2",
                name = "name2",
                phone = "phone2",
                carNumber = "carNumber2",
                route = RouteData(
                    routeId = routeId,
                    name = "name"
                )
            ),
            DriverData(
                driverId = "driverId3",
                name = "name3",
                phone = "phone3",
                carNumber = "carNumber3",
                route = RouteData(
                    routeId = routeId,
                    name = "name"
                )
            )
        )

    override suspend fun getRoutes(): List<RouteData> =
        listOf(
            RouteData(
                routeId = "routeId1",
                name = "name1"
            ),
            RouteData(
                routeId = "routeId2",
                name = "name2"
            ),
            RouteData(
                routeId = "routeId3",
                name = "name3"
            )

        )

    override suspend fun getRidersByRoute(routeId: String): List<RiderData> =
        listOf(
            RiderData(
                riderId = "riderId1",
                name = "name1",
                phone = "phone1",
                route = RouteData(
                    routeId = routeId,
                    name = "name"
                )
            ),
            RiderData(
                riderId = "riderId2",
                name = "name2",
                phone = "phone2",
                route = RouteData(
                    routeId = routeId,
                    name = "name"
                )
            ),
            RiderData(
                riderId = "riderId3",
                name = "name3",
                phone = "phone3",
                route = RouteData(
                    routeId = routeId,
                    name = "name"
                )
            )
        )

    override suspend fun updateDriver(driver: DriverData): DriverData =
        driver

    override suspend fun updateRider(rider: RiderData): RiderData =
        rider
}
