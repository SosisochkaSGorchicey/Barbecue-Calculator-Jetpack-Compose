package com.my.shashlik.presentation.components.chooseMeat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shashlickcompose.R

@Composable
fun ChooseMeatUI() {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        MeatImage(
            imageRes = R.drawable.cow
        )

        MeatImage(
            imageRes = R.drawable.chicken
        )

        MeatImage(
            imageRes = R.drawable.pig
        )

        MeatImage(
            imageRes = R.drawable.sheep,
        )
    }
}