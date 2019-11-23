package com.github.yarohovichalex.marshruber.android.driver

import androidx.fragment.app.FragmentFactory
import com.github.yarohovichalex.marshruber.android.navigation.driver.DriverNavigationActivity

class DriverActivity : DriverNavigationActivity() {
    override fun getAppFragmentFactory(): FragmentFactory =
            DriverFragmentFactory(
                    activity = this,
                    driverModules = (application as DriverApplication).driverModules
            )
}
