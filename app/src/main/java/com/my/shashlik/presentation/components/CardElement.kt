package com.my.shashlik.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun CardElement(
    @StringRes titleTextRes: Int,
    content: @Composable() (ColumnScope.() -> Unit)
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(0.95f),
        shape = RoundedCornerShape(24.dp)
    ) {
        Text(
            text = stringResource(titleTextRes),
            modifier = Modifier.padding(top = 6.dp, start = 14.dp, end = 14.dp),
            style = MaterialTheme.typography.titleMedium
        )

        content()
    }
}