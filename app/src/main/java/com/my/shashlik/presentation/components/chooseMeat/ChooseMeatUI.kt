package com.my.shashlik.presentation.components.chooseMeat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shashlickcompose.R
import com.my.shashlik.presentation.mvi.MainScreenState

@Composable
fun ChooseMeatUI(
    state: MainScreenState
) {
    Row(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        MeatImage(
            imageRes = R.drawable.cow,
            state = state
        )

        MeatImage(
            imageRes = R.drawable.chicken,
            state = state
        )

        MeatImage(
            imageRes = R.drawable.pig,
            state = state
        )

        MeatImage(
            imageRes = R.drawable.sheep,
            state = state
        )
    }
}