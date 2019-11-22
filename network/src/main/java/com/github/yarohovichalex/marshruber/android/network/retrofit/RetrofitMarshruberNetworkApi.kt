package com.github.yarohovichalex.marshruber.android.network.retrofit

import com.github.yarohovichalex.marshruber.android.common.MarshruberNetworkApi
import com.github.yarohovichalex.marshruber.android.common.data.DriverData

class RetrofitMarshruberNetworkApi(
    private val marshruberRestService: MarshruberRestService
) : MarshruberNetworkApi {

    override suspend fun getDriverList(): List<DriverData> =
            marshruberRestService.getDriverList()
                    .map { dto ->
                        DriverData(
                                driverId = dto.driverId,
                                name = dto.name,
                                phone = dto.phone
                        )
                    }
}
