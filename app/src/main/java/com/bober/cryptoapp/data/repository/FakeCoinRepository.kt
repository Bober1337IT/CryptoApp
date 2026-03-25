package com.bober.cryptoapp.data.repository


import com.bober.cryptoapp.domain.model.Coin
import com.bober.cryptoapp.domain.model.CoinDetail
import com.bober.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class FakeCoinRepository @Inject constructor() : CoinRepository {

    override suspend fun getCoins(): List<Coin> {
        return listOf(
            Coin(
                id = "1",
                isActive = true,
                name = "MockCoin",
                rank = 1,
                symbol = "MOCK",
            ),
            Coin(
                id = "2",
                isActive = false,
                name = "MockCoinMaxx",
                rank = 2,
                symbol = "MOCKX",
            )

        )
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
        return CoinDetail(
            coinId = coinId,
            name = "MockCoin",
            description = "Bober is the most powerful being",
            symbol = "MOCK",
            rank = 1,
            isActive = true,
            tags = listOf("mock", "test", "crypto"),
            team = emptyList()
        )
    }
}