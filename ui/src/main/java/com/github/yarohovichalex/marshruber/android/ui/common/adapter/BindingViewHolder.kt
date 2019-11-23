package com.github.yarohovichalex.marshruber.android.ui.common.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class BindingViewHolder<T : ViewBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
