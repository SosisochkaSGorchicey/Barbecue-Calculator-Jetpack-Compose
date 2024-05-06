package com.my.shashlik.presentation.components.chooseMeat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.my.shashlik.presentation.mvi.MeatType

@Composable
fun ChooseMeatUI() {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        MeatImage(
            meatType = MeatType.Cow
        )

        MeatImage(
            meatType = MeatType.Chicken
        )

        MeatImage(
            meatType = MeatType.Pig
        )

        MeatImage(
            meatType = MeatType.Sheep
        )
    }
}