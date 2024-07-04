package com.joaovitor.coinappmb.repository

import com.joaovitor.coinappmb.ui.model.response.Exchange

interface Repository {
    suspend fun fetchExchange(): List<Exchange>
}