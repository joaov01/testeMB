package com.joaovitor.coinappmb.repository

import com.joaovitor.coinappmb.data.ApiClient
import com.joaovitor.coinappmb.ui.model.response.Exchange
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RepositoryImpl : Repository {
    override suspend fun fetchExchange(): List<Exchange> {
        val apiService = ApiClient.retrofitClient

       return withContext(Dispatchers.IO) {
            apiService.getExchanges()
        }
    }
}