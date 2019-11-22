package com.github.yarohovichalex.marshruber.android.navigation.rider

import android.app.Activity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.github.yarohovichalex.marshruber.android.common.navigations.RiderAppNavigation

class JetpackRiderAppNavigation(
    private val activity: Activity
) : RiderAppNavigation {

    private val navController: NavController by lazy {
        Navigation.findNavController(activity, R.id.navHostFragment)
    }

    override fun goBack(): Boolean =
            navController.popBackStack()
}
