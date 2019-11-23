package com.github.yarohovichalex.marshruber.android.ui.rider.drivers

import android.os.Bundle
import com.github.yarohovichalex.marshruber.android.ui.common.BaseFragment

class RiderDriverListFragment(
    presenterProvider: (args: Bundle?) -> RiderDriverListPresenter
) : BaseFragment<RiderDriverListPresenter>(presenterProvider)
