package com.bober.cryptoapp.presentation.coin_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bober.cryptoapp.common.roundTo2Decimals

@Composable
fun CoinPriceChange(
    period: String,
    percentage: Double?,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
            .padding(4.dp)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = period,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = if (percentage != null) "${percentage.roundTo2Decimals()}%" else "N/A",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = when {
                percentage == null || percentage == 0.0 -> MaterialTheme.colorScheme.onSurface
                percentage > 0 -> Color.Green
                else -> Color.Red
            }
        )
    }
}
