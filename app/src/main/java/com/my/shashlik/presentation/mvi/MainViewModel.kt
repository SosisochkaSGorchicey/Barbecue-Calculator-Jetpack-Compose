package com.my.shashlik.presentation.mvi

import com.example.shashlickcompose.R
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import kotlin.math.roundToInt

class MainViewModel : MviViewModel<MainScreenState, Any, MainScreenEvent>(
    initialState = MainScreenState()
) {
    override fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnMeatClick -> changeCurrentMeatType(meatType = event.meatType)
            is MainScreenEvent.OnPeopleAmountChange -> changePeopleAmount(event.newAmount)
            is MainScreenEvent.OnTimeCoefChange -> changeTimeCoef(event.newTimeCoef)
            is MainScreenEvent.OnHungerSliderChange -> changeSliderPosition(event.newSliderValue)
            MainScreenEvent.CountResult -> resultCount()
        }
    }

    private fun changeCurrentMeatType(meatType: MeatType) = intent {
        reduce {
            state.copy(meatType = meatType)
        }
    }

    @OptIn(OrbitExperimental::class)
    private fun changePeopleAmount(newPeopleAmount: Int) = blockingIntent {
        reduce {
            state.copy(peopleAmount = newPeopleAmount)
        }
    }

    private fun changeTimeCoef(newTimeCoef: Double) = intent {
        reduce {
            state.copy(chosenTimeCoef = newTimeCoef)
        }
    }

    private fun changeSliderPosition(newSliderPosition: Float) = intent {
        changeSliderThumbImageRes(newSliderPosition)
        reduce {
            state.copy(currentSliderPosition = newSliderPosition)
        }
    }

    private fun changeSliderThumbImageRes(newSliderPosition: Float) = intent {
        reduce {
            when (newSliderPosition) {
                in 0f..25f -> state.copy(
                    currentSliderThumbImageRes = R.drawable.face_f1,
                    currentHungerCoef = 0.0
                )

                in 25f..50f -> state.copy(
                    currentSliderThumbImageRes = R.drawable.face_f2,
                    currentHungerCoef = .1
                )

                in 50f..75f -> state.copy(
                    currentSliderThumbImageRes = R.drawable.face_f3,
                    currentHungerCoef = .2
                )

                else -> state.copy(
                    currentSliderThumbImageRes = R.drawable.face_f4,
                    currentHungerCoef = .3
                )
            }
        }
    }

    private fun resultCount() = intent {
        when (state.peopleAmount) {
            0 -> postSideEffect(MainScreenSideEffect.ShowNoPeopleAmountErrorSnackBar)
            !in 1..50 -> postSideEffect(MainScreenSideEffect.ShowAmountErrorSnackBar)
            else -> {
                with(state) {
                    reduce {
                        val countedAmount =
                            (peopleAmount * (meatType.meatCoef + chosenTimeCoef + currentHungerCoef) * 100).roundToInt() / 100.0
                        copy(result = countedAmount)
                    }
                }
            }
        }
    }
}