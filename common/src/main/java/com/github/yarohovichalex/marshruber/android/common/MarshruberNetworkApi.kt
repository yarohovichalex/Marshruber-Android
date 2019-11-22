package com.github.yarohovichalex.marshruber.android.common

import com.github.yarohovichalex.marshruber.android.common.data.DriverData

interface MarshruberNetworkApi {
    suspend fun getDriverList(): List<DriverData>
}
