package com.my.shashlik.presentation.components.chooseHunger

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.my.shashlik.presentation.mvi.MainScreenEvent
import com.my.shashlik.presentation.mvi.MainViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseHungerUI(
    mainViewModel: MainViewModel = koinViewModel()
) {
    val state by mainViewModel.container.stateFlow.collectAsState()

    Slider(
        modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp),
        value = state.currentSliderPosition,
        onValueChange = {
            mainViewModel.onEvent(MainScreenEvent.OnHungerSliderChange(newSliderValue = it))
        },
        colors = SliderDefaults.colors(
            inactiveTrackColor = MaterialTheme.colorScheme.onSecondary.copy(.5f)
        ),
        valueRange = state.sliderRange,
        thumb = {
            Image(
                modifier = Modifier.size(44.dp),
                painter = painterResource(id = state.currentSliderThumbImageRes),
                contentDescription = null
            )
        }
    )
}