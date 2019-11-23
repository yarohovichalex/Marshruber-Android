package com.github.yarohovichalex.marshruber.android.ui.driver.route

import android.os.Bundle
import com.github.yarohovichalex.marshruber.android.ui.common.BaseFragment

class DriverRouteFragment(
    presenterProvider: (args: Bundle?) -> DriverRoutePresenter
) : BaseFragment<DriverRoutePresenter>(presenterProvider)
