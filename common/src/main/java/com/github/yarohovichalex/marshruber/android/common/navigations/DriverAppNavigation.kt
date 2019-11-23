package com.github.yarohovichalex.marshruber.android.common.navigations

import com.github.yarohovichalex.marshruber.android.common.data.DriverData

interface DriverAppNavigation {
    fun goBack(): Boolean
    fun navigateToRouteList(driver: DriverData)
    fun navigateToRiderList(driver: DriverData)
    fun navigateToDriver()
}
