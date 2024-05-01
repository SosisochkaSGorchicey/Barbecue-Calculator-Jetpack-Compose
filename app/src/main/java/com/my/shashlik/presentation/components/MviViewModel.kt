package com.my.shashlik.presentation.components

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

abstract class MviViewModel<S : Any, SE : Any, E : Any>(
    initialState: S,
) : ViewModel(), ContainerHost<S, SE> {

    override val container = viewModelScope.container<S, SE>(initialState = initialState)

    abstract fun onEvent(event: E)
}