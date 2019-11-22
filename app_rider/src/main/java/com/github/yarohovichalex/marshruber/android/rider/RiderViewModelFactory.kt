package com.github.yarohovichalex.marshruber.android.rider

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import timber.log.Timber

class RiderViewModelFactory(
    private val riderModules: RiderModules
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        Timber.d("RiderViewModelFactory:instantiate:$modelClass")
        return when {

            else -> modelClass.getConstructor().newInstance()
        }
    }
}
