package com.github.yarohovichalex.marshruber.android.network.retrofit

import com.github.yarohovichalex.marshruber.android.network.NetworkConstants
import com.github.yarohovichalex.marshruber.android.network.data.DriverDto
import com.github.yarohovichalex.marshruber.android.network.data.RiderDto
import com.github.yarohovichalex.marshruber.android.network.data.RouteDto
import retrofit2.http.GET
import retrofit2.http.POST

interface MarshruberRestService {

    @GET(NetworkConstants.GET_GET_DRIVERS_BY_ROUTE)
    suspend fun getDriversByRoute(route: String): List<DriverDto>

//    @GET(NetworkConstants.GET_RIDER_BY_PHONE)
//    suspend fun getRiderByPhone(phone: String): RiderDto

    @GET(NetworkConstants.GET_ROUTES)
    suspend fun getRoutes(): List<RouteDto>

    @GET(NetworkConstants.GET_RIDERS_BY_ROUTE)
    suspend fun getRidersByRoute(route_id: String): List<RiderDto>

    @POST(NetworkConstants.START_ROUTE_FOR_DRIVER)
    suspend fun startRouteForDriver(driver: DriverDto): DriverDto

    @POST(NetworkConstants.START_ROUTE_FOR_RIDER)
    suspend fun startRouteForRider(riderDto: RiderDto): RiderDto

    @POST(NetworkConstants.FINISH_ROUTE_FOR_DRIVER)
    suspend fun finishRouteForDriver(driverId: String): DriverDto

    @POST(NetworkConstants.FINISH_ROUTE_FOR_RIDER)
    suspend fun finishRouteForRider(riderId: String): RiderDto
}
