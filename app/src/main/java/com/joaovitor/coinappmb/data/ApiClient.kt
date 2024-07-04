package com.joaovitor.coinappmb.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://rest.coinapi.io/"
    const val API_KEY = "9EAFC0C0-5A1E-4B0F-88F3-559AA90ACCC5"

    val retrofitClient: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}