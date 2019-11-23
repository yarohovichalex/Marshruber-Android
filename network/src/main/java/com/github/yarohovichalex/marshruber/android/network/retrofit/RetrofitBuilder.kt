package com.github.yarohovichalex.marshruber.android.network.retrofit

import com.github.yarohovichalex.marshruber.android.network.NetworkConstants
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitBuilder {

    fun buildMarshruberRestService(
        moshi: Moshi
    ): MarshruberRestService {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(NetworkConstants.API_PATH)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        return retrofit.create(MarshruberRestService::class.java)
    }
}
