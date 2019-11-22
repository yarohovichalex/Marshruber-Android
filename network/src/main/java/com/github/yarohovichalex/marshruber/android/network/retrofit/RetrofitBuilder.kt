package com.github.yarohovichalex.marshruber.android.network.retrofit

import com.github.yarohovichalex.marshruber.android.network.NetworkConstants
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {

    fun buildMarshruberRestService(): MarshruberRestService {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(NetworkConstants.API_PATH)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        return retrofit.create(MarshruberRestService::class.java)
    }
}
