package com.bober.cryptoapp.domain.repository

import com.bober.cryptoapp.data.remote.dto.CoinDetailDto
import com.bober.cryptoapp.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}