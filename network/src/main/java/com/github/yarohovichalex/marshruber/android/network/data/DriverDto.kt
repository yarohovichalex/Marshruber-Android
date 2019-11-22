package com.github.yarohovichalex.marshruber.android.network.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DriverDto(
    @Json(name = "driver_id") val driverId: String,
    @Json(name = "name") val name: String,
    @Json(name = "phone") val phone: String
)
