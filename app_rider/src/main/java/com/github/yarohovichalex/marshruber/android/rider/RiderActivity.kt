package com.github.yarohovichalex.marshruber.android.rider

import androidx.fragment.app.FragmentFactory
import com.github.yarohovichalex.marshruber.android.navigation.rider.RiderNavigationActivity

class RiderActivity : RiderNavigationActivity() {
    override fun getAppFragmentFactory(): FragmentFactory =
            RiderFragmentFactory(
                    activity = this,
                    riderModules = (application as RiderApplication).riderModules
            )
}
