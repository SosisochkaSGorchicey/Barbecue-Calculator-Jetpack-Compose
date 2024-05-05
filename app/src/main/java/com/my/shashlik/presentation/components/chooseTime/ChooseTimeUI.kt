package com.my.shashlik.presentation.components.chooseTime

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.my.shashlik.presentation.mvi.MainScreenEvent
import com.my.shashlik.presentation.mvi.MainViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun ChooseTimeUI(mainViewModel: MainViewModel = koinViewModel()) {
    val state by mainViewModel.container.stateFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .selectableGroup()
    ) {
        timeOptionsTextResToValue.forEach { textResToValue ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    modifier = Modifier.size(40.dp),
                    selected = (textResToValue.second == state.chosenTimeCoef),
                    onClick = {
                        mainViewModel.onEvent(MainScreenEvent.OnTimeCoefChange(newTimeCoef = textResToValue.second))
                    }
                )

                Text(
                    modifier = Modifier.wrapContentHeight(),
                    text = stringResource(id = textResToValue.first),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }
    }
}