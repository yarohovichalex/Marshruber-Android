package com.github.yarohovichalex.marshruber.android.ui.driver.driving

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.yarohovichalex.marshruber.android.ui.R
import com.github.yarohovichalex.marshruber.android.ui.RiderAdapter
import com.github.yarohovichalex.marshruber.android.ui.common.BaseFragment
import com.github.yarohovichalex.marshruber.android.ui.databinding.FragmentDrivingRouteBinding
import com.github.yarohovichalex.marshruber.android.ui.databinding.LayoutDrivingRouteNormalBinding
import com.github.yarohovichalex.marshruber.android.ui.databinding.LayoutGenericErrorBinding
import timber.log.Timber

class DrivingRouteFragment(
    presenterProvider: (args: Bundle?) -> DrivingRoutePresenter
) : BaseFragment<DrivingRoutePresenter>(presenterProvider) {

    private lateinit var fragmentBinding: FragmentDrivingRouteBinding
    private lateinit var normalStateBinding: LayoutDrivingRouteNormalBinding
    private lateinit var errorStateBinding: LayoutGenericErrorBinding

    private val riderAdapter = RiderAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentDrivingRouteBinding.inflate(
            inflater,
            container,
            false
        ).also {
            fragmentBinding = it
            fragmentBinding.pullToRefresh.setOnRefreshListener { presenter.requestData() }
        }

        LayoutDrivingRouteNormalBinding.inflate(
            inflater,
            container,
            false
        ).also {
            normalStateBinding = it
            normalStateBinding.recyclerView.adapter = riderAdapter
            normalStateBinding.startButton.setOnClickListener { presenter.finishRoute() }
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
            getString(R.string.header_rider_list)

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

    private fun changeState(state: DrivingRouteState) {
        val stateBinding = when (state) {
            is NormalDrivingRouteState -> normalStateBinding
            is ErrorDrivingRouteState -> errorStateBinding
        }

        if (fragmentBinding.containerContent.getChildAt(0) != stateBinding.root) {
            fragmentBinding.containerContent.removeAllViews()
            fragmentBinding.containerContent.addView(stateBinding.root)
        }

        when (state) {
            is NormalDrivingRouteState -> {
                riderAdapter.submitList(state.riderList)
            }

            is ErrorDrivingRouteState -> {
                Timber.e(state.error)
                errorStateBinding.errorMessage.text = state.error.message
            }
        }
    }
}
