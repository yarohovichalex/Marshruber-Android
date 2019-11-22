package com.github.yarohovichalex.marshruber.android.network.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RiderDto(
    @Json(name = "rider_id") val riderId: String,
    @Json(name = "name") val name: String,
    @Json(name = "phone") val phone: String,
    @Json(name = "route_id") val routeId: String
)
