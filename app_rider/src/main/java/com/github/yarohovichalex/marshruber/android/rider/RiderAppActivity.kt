package com.github.yarohovichalex.marshruber.android.rider

import androidx.fragment.app.FragmentFactory
import com.github.yarohovichalex.marshruber.android.navigation.rider.RiderNavigationActivity

class RiderAppActivity : RiderNavigationActivity() {
    override fun getAppFragmentFactory(): FragmentFactory =
            FragmentFactory()
}
