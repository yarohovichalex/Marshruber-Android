package com.github.yarohovichalex.marshruber.android.ui.rider.profile

import android.os.Bundle
import com.github.yarohovichalex.marshruber.android.ui.common.BaseFragment

class RiderProfileFragment(
    presenterProvider: (args: Bundle?) -> RiderProfilePresenter
) : BaseFragment<RiderProfilePresenter>(presenterProvider)
