package com.github.yarohovichalex.marshruber.android.ui.driver.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.yarohovichalex.marshruber.android.ui.R
import com.github.yarohovichalex.marshruber.android.ui.common.BaseFragment
import com.github.yarohovichalex.marshruber.android.ui.databinding.FragmentDriverStartRouteBinding
import com.github.yarohovichalex.marshruber.android.ui.databinding.LayoutDriverStartRouteNormalBinding
import com.github.yarohovichalex.marshruber.android.ui.databinding.LayoutGenericErrorBinding
import timber.log.Timber

class DriverStartRouteFragment(
    presenterProvider: (args: Bundle?) -> DriverStartRoutePresenter
) : BaseFragment<DriverStartRoutePresenter>(presenterProvider) {

    private lateinit var fragmentBinding: FragmentDriverStartRouteBinding
    private lateinit var normalStateBinding: LayoutDriverStartRouteNormalBinding
    private lateinit var errorStateBinding: LayoutGenericErrorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentDriverStartRouteBinding.inflate(
            inflater,
            container,
            false
        ).also {
            fragmentBinding = it
            fragmentBinding.pullToRefresh.setOnRefreshListener { presenter.requestData() }
        }

        LayoutDriverStartRouteNormalBinding.inflate(
            inflater,
            container,
            false
        ).also {
            normalStateBinding = it
            normalStateBinding.startButton.setOnClickListener {
                presenter.driverStartRoute(
                    driverName = normalStateBinding.nameInputEditText.text.toString(),
                    driverPhone = normalStateBinding.phoneNumberInputEditText.toString(),
                    driverCarNumber = normalStateBinding.carNumberInputEditText.toString()
                )
            }
        }

        LayoutGenericErrorBinding.inflate(
            inflater,
            container,
            false
        ).also {
            errorStateBinding = it
        }

        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as? AppCompatActivity)?.supportActionBar?.title =
            getString(R.string.headerDriverMenu)

        presenter.requestData()
    }

    override fun observeDataSources() {
        super.observeDataSources()

        presenter.getLoadingData().observe(
            viewLifecycleOwner,
            Observer { fragmentBinding.pullToRefresh.isRefreshing = it }
        )

        presenter.getStateData().observe(viewLifecycleOwner, Observer { changeState(it) })
    }

    private fun changeState(state: DriverStartRouteState) {
        val stateBinding = when (state) {
            is NormalDriverStartRouteState -> normalStateBinding
            is ErrorDriverStartRouteState -> errorStateBinding
        }

        if (fragmentBinding.containerContent.getChildAt(0) != stateBinding.root) {
            fragmentBinding.containerContent.removeAllViews()
            fragmentBinding.containerContent.addView(stateBinding.root)
        }

        when (state) {
            is NormalDriverStartRouteState -> {
                normalStateBinding.nameInputEditText.setText(state.driverName)
                normalStateBinding.phoneNumberInputEditText.setText(state.driverPhone)
                normalStateBinding.carNumberInputEditText.setText(state.driverCarNumber)
            }

            is ErrorDriverStartRouteState -> {
                Timber.e(state.error)
                errorStateBinding.errorMessage.text = state.error.message
            }
        }
    }
}
