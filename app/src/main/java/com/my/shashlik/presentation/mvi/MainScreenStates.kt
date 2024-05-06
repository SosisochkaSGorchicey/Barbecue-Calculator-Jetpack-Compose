package com.my.shashlik.presentation.mvi

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import com.example.shashlickcompose.R

@Immutable
data class MainScreenState(
    val meatType: MeatType = MeatType.Cow,
    val peopleAmount: Int = 0,
    val chosenTimeCoef: Double = 0.0,
    val currentSliderPosition: Float = 10f,
    val sliderRange: ClosedFloatingPointRange<Float> = 0f..100f,
    @DrawableRes val currentSliderThumbImageRes: Int = R.drawable.face_f1,
    val currentHungerCoef: Double = 0.0,
    val result: Double? = null
)

sealed class MainScreenEvent {
    data class OnMeatClick(val meatType: MeatType) : MainScreenEvent()
    data class OnPeopleAmountChange(val newAmount: Int) : MainScreenEvent()
    data class OnTimeCoefChange(val newTimeCoef: Double) : MainScreenEvent()
    data class OnHungerSliderChange(val newSliderValue: Float) : MainScreenEvent()
    data object CountResult : MainScreenEvent()
}

sealed class MainScreenSideEffect {
    data object ShowNoPeopleAmountErrorSnackBar : MainScreenSideEffect()
    data object ShowAmountErrorSnackBar : MainScreenSideEffect()
}

enum class MeatType(
    @DrawableRes val imageRes: Int = R.drawable.cow,
    val meatCoef: Double = 0.3
) {
    Cow(
        imageRes = R.drawable.cow,
        meatCoef = 0.3
    ),
    Chicken(
        imageRes = R.drawable.chicken,
        meatCoef = 0.35
    ),
    Pig(
        imageRes = R.drawable.pig,
        meatCoef = 0.3
    ),
    Sheep(
        imageRes = R.drawable.sheep,
        meatCoef = 0.3
    )
}