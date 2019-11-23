package com.github.yarohovichalex.marshruber.android.rider

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import com.github.yarohovichalex.marshruber.android.common.navigations.RiderAppNavigation
import com.github.yarohovichalex.marshruber.android.navigation.rider.JetpackRiderAppNavigation
import timber.log.Timber

class RiderFragmentFactory(
    private val activity: FragmentActivity,
    private val riderModules: RiderModules
) : FragmentFactory() {

    private val riderAppNavigation: RiderAppNavigation by lazy { JetpackRiderAppNavigation(activity) }

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        Timber.d("RiderFragmentFactory:instantiate:$className")
        return when (className) {
            else -> super.instantiate(classLoader, className)
        }
    }
}
