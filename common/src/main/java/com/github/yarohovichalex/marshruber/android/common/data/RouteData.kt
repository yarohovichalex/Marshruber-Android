package com.github.yarohovichalex.marshruber.android.common.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RouteData(
    val routeId: String,
    val name: String
) : Parcelable
