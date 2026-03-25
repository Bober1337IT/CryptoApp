package com.bober.cryptoapp.data.remote

import com.bober.cryptoapp.data.remote.dto.CoinDetailDto
import com.bober.cryptoapp.data.remote.dto.CoinDto
import com.bober.cryptoapp.data.remote.dto.CoinPriceDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

    @GET("v1/tickers/{coinId}")
    suspend fun getCoinPriceById(@Path("coinId") coinId: String): CoinPriceDto
}