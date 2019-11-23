package com.github.yarohovichalex.marshruber.android.ui

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.github.yarohovichalex.marshruber.android.common.data.RouteData

class RouteSpinnerAdapter(
    context: Context
) : ArrayAdapter<RouteData>(context, android.R.layout.simple_spinner_item) {

    fun setData(list: List<RouteData>) {
        clear()
        addAll(list)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val label = super.getView(position, convertView, parent) as TextView
        label.text = getItem(position)?.name
        return label
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val label = super.getView(position, convertView, parent) as TextView
        label.text = getItem(position)?.name
        return label
    }
}
