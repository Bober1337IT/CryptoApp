package com.bober.cryptoapp.data.repository

import com.bober.cryptoapp.data.remote.CoinPaprikaApi
import com.bober.cryptoapp.data.remote.dto.toCoin
import com.bober.cryptoapp.data.remote.dto.toCoinDetail
import com.bober.cryptoapp.domain.model.Coin
import com.bober.cryptoapp.domain.model.CoinDetail
import com.bober.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return api.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        val detailDto = api.getCoinById(coinId)
        val priceDto = api.getCoinPriceById(coinId)

        return priceDto.toCoinDetail(detailDto.toCoinDetail())
    }
}