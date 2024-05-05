package com.my.shashlik.presentation.mvi

import androidx.annotation.DrawableRes
import com.my.shashlik.presentation.components.MviViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce

class MainViewModel : MviViewModel<MainScreenState, Any, MainScreenEvent>(
    initialState = MainScreenState()
) {
    override fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnMeatClick -> changeCurrentMeatType(newImageRes = event.newImageRes)
        }
    }

    private fun changeCurrentMeatType(@DrawableRes newImageRes: Int) = intent {
        reduce {
            state.copy(chosenImageRes = newImageRes)
        }
    }
}