package com.github.yarohovichalex.marshruber.android.network.storage

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.github.yarohovichalex.marshruber.android.common.MarshruberStorageApi
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.data.RiderData
import com.github.yarohovichalex.marshruber.android.network.data.DriverDto
import com.github.yarohovichalex.marshruber.android.network.data.RouteDto

class MurshruberStorageApiImpl (
    context:Context
) : MarshruberStorageApi {

    val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);

    override suspend fun getDriverStorage(): DriverData? {
//        val driver = sharedPreferences.getString("driver", "driver")
//        return DriverData(driver.)
        TODO("not implemented")
    }

    override suspend fun putDriverStorage(driver: DriverData) {
//        sharedPreferences.edit().putString("driver", DriverDto(driver.driverId, driver.name, driver.phone, RouteDto(driver.route.routeId, driver.route.name), driver.carNumber).toString() ).apply()
        TODO("not implemented")
    }

    override suspend fun getRiderStorage(): DriverData? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun putRiderStorage(rider: RiderData) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}