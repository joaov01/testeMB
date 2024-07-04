package com.joaovitor.coinappmb.ui.model.response

data class Exchange(
    val exchange_id: String,
    val website: String,
    val name: String,
    val data_start: String,
    val data_end: String,
    val data_quote_start: String,
    val data_quote_end: String,
    val data_orderbook_start: String,
    val data_orderbook_end: String,
    val data_trade_start: String,
    val data_trade_end: String,
    val data_symbols_count: Int,
    val volume_1hrs_usd: Double,
    val volume_1day_usd: Double,
    val volume_1mth_usd: Double
)
