package com.bober.cryptoapp.domain.repository

import com.bober.cryptoapp.data.remote.dto.CoinDto
import com.bober.cryptoapp.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetail
}