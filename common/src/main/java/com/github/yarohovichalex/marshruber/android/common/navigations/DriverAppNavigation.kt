package com.github.yarohovichalex.marshruber.android.common.navigations

import com.github.yarohovichalex.marshruber.android.common.data.DriverData

interface DriverAppNavigation {
    fun goBack(): Boolean
    fun navigateToDrivingRoute(driver: DriverData)
    fun navigateToDriverRoute(driver: DriverData)
    fun navigateToDriverStartRoute()
}
