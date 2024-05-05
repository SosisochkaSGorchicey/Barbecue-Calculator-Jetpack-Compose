package com.my.shashlik.presentation.mvi

import androidx.annotation.DrawableRes
import com.example.shashlickcompose.R
import com.my.shashlik.presentation.components.MviViewModel
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class MainViewModel : MviViewModel<MainScreenState, Any, MainScreenEvent>(
    initialState = MainScreenState()
) {
    override fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnMeatClick -> changeCurrentMeatType(newImageRes = event.newImageRes)
            is MainScreenEvent.OnPeopleAmountChange -> changePeopleAmount(event.newAmount)
            is MainScreenEvent.OnTimeCoefChange -> changeTimeCoef(event.newTimeCoef)
            is MainScreenEvent.OnHungerSliderChange -> changeSliderPosition(event.newSliderValue)
        }
    }

    private fun changeCurrentMeatType(@DrawableRes newImageRes: Int) = intent {
        reduce {
            state.copy(chosenImageRes = newImageRes)
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
                in 0f..25f -> state.copy(currentSliderThumbImageRes = R.drawable.face_f1)
                in 25f..50f -> state.copy(currentSliderThumbImageRes = R.drawable.face_f2)
                in 50f..75f -> state.copy(currentSliderThumbImageRes = R.drawable.face_f3)
                else -> state.copy(currentSliderThumbImageRes = R.drawable.face_f4)
            }
        }
    }
}