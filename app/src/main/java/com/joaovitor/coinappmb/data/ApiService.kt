package com.joaovitor.coinappmb.data

import com.joaovitor.coinappmb.ui.model.response.Exchange
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers


interface ApiService {
    @Headers("X-CoinAPI-Key: ${ApiClient.API_KEY}")
    @GET("v1/exchanges")
    suspend fun getExchanges(): List<Exchange>
}