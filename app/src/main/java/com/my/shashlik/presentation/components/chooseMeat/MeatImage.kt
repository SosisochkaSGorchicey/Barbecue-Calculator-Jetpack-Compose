package com.my.shashlik.presentation.components.chooseMeat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.my.shashlik.presentation.mvi.MainScreenEvent
import com.my.shashlik.presentation.mvi.MainViewModel
import com.my.shashlik.presentation.mvi.MeatType
import com.my.shashlik.ui.theme.CardTextColorHint
import org.koin.androidx.compose.koinViewModel

@Composable
fun RowScope.MeatImage(
    meatType: MeatType,
    mainViewModel: MainViewModel = koinViewModel()
) {
    val state by mainViewModel.container.stateFlow.collectAsState()

    Image(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(22.dp))
            .weight(1f)
            .background(
                if (state.meatType == meatType) CardTextColorHint
                else Color.Transparent
            )
            .clickable {
                mainViewModel.onEvent(MainScreenEvent.OnMeatClick(meatType = meatType))
            },
        painter = painterResource(id = meatType.imageRes),
        contentDescription = null
    )
}