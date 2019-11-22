package com.github.yarohovichalex.marshruber.android.network.retrofit

import com.github.yarohovichalex.marshruber.android.common.MarshruberNetworkApi
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RiderData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData
import com.github.yarohovichalex.marshruber.android.network.data.DriverDto
import com.github.yarohovichalex.marshruber.android.network.data.RiderDto
import com.github.yarohovichalex.marshruber.android.network.data.RouteDto

class RetrofitMarshruberNetworkApi(
    private val marshruberRestService: MarshruberRestService
) : MarshruberNetworkApi {

    override suspend fun getDriversByRoute(route: String): List<DriverData> =
            marshruberRestService.getDriversByRoute(route)
                    .map { dto ->
                        DriverData(
                                driverId = dto.driverId,
                                name = dto.name,
                                phone = dto.phone,
                                route = RouteData(dto.route.routeId, dto.route.name),
                                carNumber = dto.carNumber
                        )
                    }

    override suspend fun getRoutes(): List<RouteData> =
            marshruberRestService.getRoutes()
                    .map { dto ->
                        RouteData(
                                routeId = dto.routeId,
                                name = dto.name
                        )
                    }

    override suspend fun getRidersByRoute(routeId: String): List<RiderData> =
            marshruberRestService.getRidersByRoute(routeId)
                    .map { dto ->
                        RiderData(
                                riderId = dto.riderId,
                                name = dto.name,
                                phone = dto.phone,
                                route = RouteData(dto.route.routeId, dto.route.name)
                        )
                    }

    override suspend fun updateDriver(driver: DriverData): DriverData {
        var driverDto = DriverDto(driver.driverId, driver.name, driver.phone, RouteDto(driver.route.routeId, driver.route.name), driver.carNumber)
        driverDto = marshruberRestService.startRouteForDriver(driverDto)
        return DriverData(driverDto.driverId, driverDto.name, driver.phone, RouteData(driver.route.routeId, driver.route.name), driver.carNumber)
    }

    suspend fun startRouteForDriver1(driver: DriverData): DriverData =
            DriverDto(driver.driverId, driver.name, driver.phone, RouteDto(driver.route.routeId, driver.route.name), driver.carNumber).let { driverDto ->
                marshruberRestService.startRouteForDriver(driverDto)
            }.let { driverDto ->
                DriverData(driverDto.driverId, driverDto.name, driver.phone, RouteData(driver.route.routeId, driver.route.name), driver.carNumber)
            }

    override suspend fun updateRider(rider: RiderData): RiderData {
        var riderDto = RiderDto(rider.riderId, rider.name, rider.phone, RouteDto(rider.route.routeId, rider.route.name))
        riderDto = marshruberRestService.startRouteForRider(riderDto)
        return RiderData(riderDto.riderId, riderDto.name, riderDto.phone, RouteData(rider.route.routeId, rider.route.name))
    }
}
