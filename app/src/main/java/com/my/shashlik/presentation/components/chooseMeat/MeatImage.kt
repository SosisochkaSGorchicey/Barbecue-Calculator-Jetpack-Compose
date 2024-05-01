package com.my.shashlik.presentation.components.chooseMeat

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.my.shashlik.presentation.mvi.MainScreenState

@Composable
fun RowScope.MeatImage(
    @DrawableRes imageRes: Int,
    state: MainScreenState
) {
    Image(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(24.dp))
            .weight(1f)
            .background(if (state.chosenImageRes == imageRes) Color.Red
            else
            Color.Black)
            .clickable {

            },
        painter = painterResource(id = imageRes),
        contentDescription = null
    )
}