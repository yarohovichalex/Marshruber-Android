package com.github.yarohovichalex.marshruber.android.ui.common

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment<T>(
    private val presenterProvider: (arguments: Bundle?) -> T
) : Fragment() {

    protected val presenter: T by lazy { presenterProvider(arguments) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeDataSources()
    }

    protected open fun observeDataSources() {
    }
}
