package com.github.yarohovichalex.marshruber.android.network.retrofit

import com.github.yarohovichalex.marshruber.android.network.NetworkConstants
import com.github.yarohovichalex.marshruber.android.network.data.DriverDto
import retrofit2.http.GET

interface MarshruberRestService {

    @GET(NetworkConstants.DRIVER_PATH)
    suspend fun getDriverList(): List<DriverDto>
}
