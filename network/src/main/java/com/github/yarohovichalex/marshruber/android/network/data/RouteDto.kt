package com.github.yarohovichalex.marshruber.android.network.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RouteDto(
        @Json(name = "route_id") val routeId: String,
        @Json(name = "name") val name: String
)