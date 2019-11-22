package com.github.yarohovichalex.marshruber.android.navigation.driver

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.github.yarohovichalex.marshruber.android.common.navigations.DriverAppNavigation

class JetpackDriverAppNavigation(
    private val activity: Activity
) : DriverAppNavigation {

    private val navController: NavController by lazy {
        Navigation.findNavController(activity, R.id.navHostFragment)
    }

    override fun goBack(): Boolean =
            navController.popBackStack()
}
