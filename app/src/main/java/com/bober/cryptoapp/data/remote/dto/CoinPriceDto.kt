package com.bober.cryptoapp.data.remote.dto

import com.bober.cryptoapp.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName

data class CoinPriceDto(
    @SerializedName("beta_value")
    val betaValue: Double,
    @SerializedName("first_data_at")
    val firstDataAt: String,
    val id: String,
    @SerializedName("last_updated")
    val lastUpdated: String,
    @SerializedName("max_supply")
    val maxSupply: Long,
    val name: String,
    val quotes: Quotes,
    val rank: Int,
    val symbol: String,
    @SerializedName("total_supply")
    val totalSupply: Long
)

fun CoinPriceDto.toCoinDetail(existingDetail: CoinDetail): CoinDetail {
    val usd = quotes.USD
    return existingDetail.copy(
        price = usd.price,
        dailyChange = usd.percentChange24h,
        weeklyChange = usd.percentChange7d,
        monthlyChange = usd.percentChange30d,
        yearlyChange = usd.percentChange1y
    )
}
