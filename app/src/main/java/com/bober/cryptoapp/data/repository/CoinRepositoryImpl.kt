package com.bober.cryptoapp.data.repository

import com.bober.cryptoapp.data.remote.CoinPaprikaApi
import com.bober.cryptoapp.data.remote.dto.CoinDetailDto
import com.bober.cryptoapp.data.remote.dto.CoinDto
import com.bober.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}