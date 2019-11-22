package com.github.yarohovichalex.marshruber.android.ui.common.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.viewbinding.ViewBinding

abstract class BaseRecyclerClickablePagingAdapter<T, B : ViewBinding>(
    diffCallback: DiffUtil.ItemCallback<T>
) : PagedListAdapter<T, BindingViewHolder<B>>(
        diffCallback
) {

    var onItemClickListener: (context: Context, holder: BindingViewHolder<B>, position: Int) -> Unit = { _, _, _ -> }

    @Suppress("UNCHECKED_CAST")
    private val innerClickListener = View.OnClickListener { view ->
        val holder = view.tag as BindingViewHolder<B>
        onItemClickListener(holder.itemView.context, holder, holder.adapterPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<B> {
        val inflater = LayoutInflater.from(parent.context)
        val holder = onCreateViewHolder(inflater, parent, viewType)
        holder.itemView.setOnClickListener(innerClickListener)
        holder.itemView.tag = holder
        return holder
    }

    abstract fun onCreateViewHolder(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): BindingViewHolder<B>
}
