package com.my.shashlik.presentation.mvi

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.example.shashlickcompose.R

@Immutable
data class MainScreenState(
    @DrawableRes val chosenImageRes: Int = R.drawable.cow,
    val peopleAmount: Int = 0,
    val chosenTimeCoef: Double = 0.0,
    val currentSliderPosition: Float = 10f,
    val sliderRange: ClosedFloatingPointRange<Float> = 0f..100f,
    @DrawableRes val currentSliderThumbImageRes: Int = R.drawable.face_f1,
    val result: Double? = null
)

sealed class MainScreenEvent {
    data class OnMeatClick(@DrawableRes val newImageRes: Int) : MainScreenEvent()
    data class OnPeopleAmountChange(val newAmount: Int) : MainScreenEvent()
    data class OnTimeCoefChange(val newTimeCoef: Double) : MainScreenEvent()
    data class OnHungerSliderChange(val newSliderValue: Float) : MainScreenEvent()
}