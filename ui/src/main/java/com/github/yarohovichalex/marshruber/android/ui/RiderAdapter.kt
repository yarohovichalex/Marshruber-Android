package com.github.yarohovichalex.marshruber.android.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.github.yarohovichalex.marshruber.android.common.data.RiderData
import com.github.yarohovichalex.marshruber.android.ui.common.adapter.BaseRecyclerClickableListAdapter
import com.github.yarohovichalex.marshruber.android.ui.common.adapter.BindingViewHolder
import com.github.yarohovichalex.marshruber.android.ui.databinding.ViewItemRiderBinding

class RiderAdapter : BaseRecyclerClickableListAdapter<RiderData, ViewItemRiderBinding>(
        DIFF_CALLBACK
) {
    override fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BindingViewHolder<ViewItemRiderBinding> =
            BindingViewHolder(ViewItemRiderBinding.inflate(inflater, parent, false))

    override fun onBindViewHolder(
            holder: BindingViewHolder<ViewItemRiderBinding>,
            position: Int
    ) {
        getItem(position)?.let { item: RiderData ->
            holder.binding.name.text = item.name
            holder.binding.phone.text = item.phone
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<RiderData>() {
            override fun areItemsTheSame(oldItem: RiderData, newItem: RiderData) =
                    oldItem.riderId == newItem.riderId

            override fun areContentsTheSame(oldItem: RiderData, newItem: RiderData) =
                    oldItem == newItem
        }
    }
}