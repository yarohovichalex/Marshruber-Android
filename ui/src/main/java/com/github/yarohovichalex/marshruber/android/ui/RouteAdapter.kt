package com.github.yarohovichalex.marshruber.android.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.github.yarohovichalex.marshruber.android.common.data.RouteData
import com.github.yarohovichalex.marshruber.android.ui.common.adapter.BaseRecyclerClickableListAdapter
import com.github.yarohovichalex.marshruber.android.ui.common.adapter.BindingViewHolder
import com.github.yarohovichalex.marshruber.android.ui.databinding.ViewItemRouteBinding

class RouteAdapter : BaseRecyclerClickableListAdapter<RouteData, ViewItemRouteBinding>(
    DIFF_CALLBACK
) {
    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ViewItemRouteBinding> =
        BindingViewHolder(ViewItemRouteBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(
        holder: BindingViewHolder<ViewItemRouteBinding>,
        position: Int
    ) {
        val item: RouteData = getItem(position)
        holder.binding.name.text = item.name
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RouteData>() {
            override fun areItemsTheSame(oldItem: RouteData, newItem: RouteData) =
                oldItem.routeId == newItem.routeId

            override fun areContentsTheSame(oldItem: RouteData, newItem: RouteData) =
                oldItem == newItem
        }
    }
}
