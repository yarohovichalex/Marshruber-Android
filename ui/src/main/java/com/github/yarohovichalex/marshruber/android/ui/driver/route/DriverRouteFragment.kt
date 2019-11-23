package com.github.yarohovichalex.marshruber.android.ui.driver.route

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.github.yarohovichalex.marshruber.android.ui.R
import com.github.yarohovichalex.marshruber.android.ui.RouteAdapter
import com.github.yarohovichalex.marshruber.android.ui.common.BaseFragment
import com.github.yarohovichalex.marshruber.android.ui.databinding.FragmentDriverRouteBinding
import com.github.yarohovichalex.marshruber.android.ui.databinding.LayoutDriverRouteNormalBinding
import com.github.yarohovichalex.marshruber.android.ui.databinding.LayoutGenericErrorBinding
import timber.log.Timber

class DriverRouteFragment(
    presenterProvider: (args: Bundle?) -> DriverRoutePresenter
) : BaseFragment<DriverRoutePresenter>(presenterProvider) {

    private lateinit var fragmentBinding: FragmentDriverRouteBinding
    private lateinit var normalStateBinding: LayoutDriverRouteNormalBinding
    private lateinit var errorStateBinding: LayoutGenericErrorBinding

    private val routeAdapter = RouteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        FragmentDriverRouteBinding.inflate(
            inflater,
            container,
            false
        ).also {
            fragmentBinding = it
            fragmentBinding.pullToRefresh.setOnRefreshListener { presenter.requestData() }
        }

        LayoutDriverRouteNormalBinding.inflate(
            inflater,
            container,
            false
        ).also {
            normalStateBinding = it
            normalStateBinding.recyclerView.adapter = routeAdapter
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
            getString(R.string.header_route_list)

        routeAdapter.onItemClickListener = { _, _, position ->
            presenter.driverStartRoute(routeAdapter.getItem(position))
        }

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

    private fun changeState(state: DriverRouteState) {
        val stateBinding = when (state) {
            is NormalDriverRouteState -> normalStateBinding
            is ErrorDriverRouteState -> errorStateBinding
        }

        if (fragmentBinding.containerContent.getChildAt(0) != stateBinding.root) {
            fragmentBinding.containerContent.removeAllViews()
            fragmentBinding.containerContent.addView(stateBinding.root)
        }

        when (state) {
            is NormalDriverRouteState -> {
                routeAdapter.submitList(state.routeList)
            }

            is ErrorDriverRouteState -> {
                Timber.e(state.error)
                errorStateBinding.errorMessage.text = state.error.message
            }
        }
    }
}
