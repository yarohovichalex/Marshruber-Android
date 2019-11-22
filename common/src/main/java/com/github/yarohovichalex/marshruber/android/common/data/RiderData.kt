package com.github.yarohovichalex.marshruber.android.common.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RiderData(
    val riderId: String,
    val name: String,
    val phone: String,
    val routeId: String
) : Parcelable
