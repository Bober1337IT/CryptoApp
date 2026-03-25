package com.bober.cryptoapp.domain.model

import com.bober.cryptoapp.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
    // Price
    val price: Double? = null,
    val dailyChange: Double? = null,
    val weeklyChange: Double? = null,
    val monthlyChange: Double? = null,
    val yearlyChange: Double? = null
)
