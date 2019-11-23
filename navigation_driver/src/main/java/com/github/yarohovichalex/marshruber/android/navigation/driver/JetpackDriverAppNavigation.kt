package com.github.yarohovichalex.marshruber.android.navigation.driver

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.github.yarohovichalex.marshruber.android.common.data.DriverData
import com.github.yarohovichalex.marshruber.android.common.navigations.DriverAppNavigation
import com.github.yarohovichalex.marshruber.android.ui.driver.driving.DrivingRouteFragmentDirections
import com.github.yarohovichalex.marshruber.android.ui.driver.start.DriverStartRouteFragmentDirections

class JetpackDriverAppNavigation(
    private val activity: Activity
) : DriverAppNavigation {

    private val navController: NavController by lazy {
        Navigation.findNavController(activity, R.id.navHostFragment)
    }

    override fun goBack(): Boolean =
        navController.popBackStack()

    override fun navigateToDrivingRoute(driver: DriverData) =
        navController.navigate(
            DriverStartRouteFragmentDirections.actionDriverStartToDrivingRoute(driver)
        )

    override fun navigateToDriverStartRoute() =
        navController.navigate(
            DrivingRouteFragmentDirections.actionDriverDrivingToStartRoute()
        )
}
