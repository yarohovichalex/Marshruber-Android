package com.github.yarohovichalex.marshruber.android.driver

import androidx.fragment.app.FragmentFactory
import com.github.yarohovichalex.marshruber.android.navigation.driver.DriverNavigationActivity

class DriverAppActivity : DriverNavigationActivity() {
    override fun getAppFragmentFactory(): FragmentFactory =
            FragmentFactory()
}
