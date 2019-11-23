package com.github.yarohovichalex.marshruber.android.common

import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RiderData

interface MarshruberStorageApi {

    suspend fun getDriverStorage(): DriverData?

    suspend fun putDriverStorage(driver: DriverData)

    suspend fun getRiderStorage(): DriverData?

    suspend fun putRiderStorage(rider: RiderData)
}
