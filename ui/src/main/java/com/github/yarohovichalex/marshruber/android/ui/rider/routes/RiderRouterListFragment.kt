package com.github.yarohovichalex.marshruber.android.ui.rider.routes

import android.os.Bundle
import com.github.yarohovichalex.marshruber.android.ui.common.BaseFragment

class RiderRouterListFragment(
    presenterProvider: (args: Bundle?) -> RiderRouterListPresenter
) : BaseFragment<RiderRouterListPresenter>(presenterProvider)
