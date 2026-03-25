package com.bober.cryptoapp.data.repository

import com.bober.cryptoapp.data.remote.CoinPaprikaApi
import com.bober.cryptoapp.data.remote.dto.CoinDetailDto
import com.bober.cryptoapp.data.remote.dto.CoinDto
import com.bober.cryptoapp.data.remote.dto.toCoinDetail
import com.bober.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        val detailDto = api.getCoinById(coinId)
        val priceDto = api.getCoinPriceById(coinId)
        val coinDetail = priceDto.toCoinDetail(detailDto.toCoinDetail())

        // Log to check if api works:
        println("DEBUG_CRYPTO: Price for ${coinDetail.name} is ${coinDetail.price} USD")

        return detailDto
    }
}