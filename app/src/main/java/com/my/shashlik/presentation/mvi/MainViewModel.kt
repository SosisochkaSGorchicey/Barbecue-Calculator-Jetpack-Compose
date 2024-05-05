package com.my.shashlik.presentation.mvi

import androidx.annotation.DrawableRes
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
}