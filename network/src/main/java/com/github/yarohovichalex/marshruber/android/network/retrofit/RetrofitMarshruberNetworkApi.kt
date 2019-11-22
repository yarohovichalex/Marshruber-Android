package com.github.yarohovichalex.marshruber.android.network.retrofit

import com.github.yarohovichalex.marshruber.android.common.MarshruberNetworkApi
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RiderData
import com.github.yarohovichalex.marshruber.android.common.data.RouteData
import com.github.yarohovichalex.marshruber.android.network.data.DriverDto
import com.github.yarohovichalex.marshruber.android.network.data.RiderDto

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
                                routeId = dto.routeId
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
                                routeId = dto.routeId
                        )
                    }

    override suspend fun startRouteForDriver(driver: DriverData): DriverData {
        var driverDto = DriverDto(driver.driverId, driver.name, driver.phone, driver.phone)
        driverDto = marshruberRestService.startRouteForDriver(driverDto)
        return DriverData(driverDto.driverId, driverDto.name, driver.phone, driverDto.routeId)
    }

    suspend fun startRouteForDriver1(driver: DriverData): DriverData =
            DriverDto(driver.driverId, driver.name, driver.phone, driver.phone).let { driverDto ->
                marshruberRestService.startRouteForDriver(driverDto)
            }.let { driverDto ->
                DriverData(driverDto.driverId, driverDto.name, driver.phone, driverDto.routeId)
            }

    override suspend fun startRouteForRider(rider: RiderData): RiderData{
        var riderDto = RiderDto(rider.riderId, rider.name, rider.phone, rider.phone)
        riderDto = marshruberRestService.startRouteForRider(riderDto)
        return RiderData(riderDto.riderId, riderDto.name, riderDto.phone, riderDto.routeId)
    }

    override suspend fun finishRouteForDriver(driverId: String): DriverData {
        val driverDto = marshruberRestService.finishRouteForDriver(driverId)
        return DriverData(driverDto.driverId, driverDto.name, driverDto.phone, driverDto.routeId)
    }

    override suspend fun finishRouteForRider(riderId: String): RiderData {
        val riderDto = marshruberRestService.finishRouteForRider(riderId)
        return RiderData(riderDto.riderId, riderDto.name, riderDto.phone, riderDto.routeId)
    }
}
