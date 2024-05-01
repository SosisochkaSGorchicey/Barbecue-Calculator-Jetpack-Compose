package com.my.shashlik.presentation.mvi

import com.my.shashlik.presentation.components.MviViewModel

class MainViewModel: MviViewModel<MainScreenState, Any, Any> (
    initialState = MainScreenState()
) {
    override fun onEvent(event: Any) {
        TODO("Not yet implemented")
    }
}