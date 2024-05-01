package com.my.shashlik.presentation.mvi

import androidx.annotation.DrawableRes
import com.example.shashlickcompose.R

data class MainScreenState(
    @DrawableRes val chosenImageRes: Int = R.drawable.cow
)