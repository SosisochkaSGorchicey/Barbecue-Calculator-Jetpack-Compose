package com.my.shashlik.presentation.di

import com.my.shashlik.presentation.mvi.MainViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

object PresentationModule {
    operator fun invoke() = module {
        factoryOf(::MainViewModel)
    }
}