package com.github.yarohovichalex.marshruber.android.driver

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import androidx.lifecycle.ViewModelProvider
import com.github.yarohovichalex.marshruber.android.common.navigations.DriverAppNavigation
import com.github.yarohovichalex.marshruber.android.navigation.driver.JetpackDriverAppNavigation
import com.github.yarohovichalex.marshruber.android.ui.driver.start.DriverStartRouteFragment
import com.github.yarohovichalex.marshruber.android.ui.driver.start.DriverStartRoutePresenterImpl
import com.github.yarohovichalex.marshruber.android.ui.driver.start.DriverStartRouteViewModel
import timber.log.Timber

class DriverFragmentFactory(
    private val activity: FragmentActivity,
    private val driverModules: DriverModules
) : FragmentFactory() {

    private val driverAppNavigation: DriverAppNavigation by lazy { JetpackDriverAppNavigation(activity) }

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        Timber.d("DriverFragmentFactory:instantiate:$className")
        return when (className) {

            DriverStartRouteFragment::class.java.name -> {
                val viewModel = ViewModelProvider(activity, driverModules.viewModelFactory)
                        .get(DriverStartRouteViewModel::class.java)
                DriverStartRouteFragment {
                    DriverStartRoutePresenterImpl(
                            driverStartRouteViewModel = viewModel,
                            driverAppNavigation = driverAppNavigation
                    )
                }
            }

            else -> super.instantiate(classLoader, className)
        }
    }
}
