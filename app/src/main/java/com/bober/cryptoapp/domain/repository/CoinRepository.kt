package com.bober.cryptoapp.domain.repository

import com.bober.cryptoapp.domain.model.Coin
import com.bober.cryptoapp.domain.model.CoinDetail

interface CoinRepository {

    suspend fun getCoins(): List<Coin>

    suspend fun getCoinById(coinId: String): CoinDetail
}