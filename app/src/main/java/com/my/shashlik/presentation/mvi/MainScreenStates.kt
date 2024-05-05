package com.my.shashlik.presentation.mvi

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.example.shashlickcompose.R

@Immutable
data class MainScreenState(
    @DrawableRes val chosenImageRes: Int = R.drawable.cow
)

sealed class MainScreenEvent {
    data class OnMeatClick(@DrawableRes val newImageRes: Int): MainScreenEvent()
}