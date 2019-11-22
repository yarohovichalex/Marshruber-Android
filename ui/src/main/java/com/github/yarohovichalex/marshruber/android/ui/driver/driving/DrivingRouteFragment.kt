package com.github.yarohovichalex.marshruber.android.ui.driver.driving

import android.os.Bundle
import com.github.yarohovichalex.marshruber.android.ui.common.BaseFragment

class DrivingRouteFragment(
    presenterProvider: (args: Bundle?) -> DrivingRoutePresenter
) : BaseFragment<DrivingRoutePresenter>(presenterProvider)
