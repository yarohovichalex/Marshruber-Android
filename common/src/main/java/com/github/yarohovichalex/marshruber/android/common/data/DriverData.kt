package com.github.yarohovichalex.marshruber.android.common.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DriverData(
    val driverId: String,
    val name: String,
    val phone: String
) : Parcelable
