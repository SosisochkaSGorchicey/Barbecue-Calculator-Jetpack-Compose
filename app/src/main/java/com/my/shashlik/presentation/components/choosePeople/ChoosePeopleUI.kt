package com.my.shashlik.presentation.components.choosePeople

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.shashlickcompose.R
import com.my.shashlik.presentation.mvi.MainScreenEvent
import com.my.shashlik.presentation.mvi.MainViewModel
import com.my.shashlik.ui.theme.CardTextColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun ChoosePeopleUI(
    mainViewModel: MainViewModel = koinViewModel()
) {
    val state by mainViewModel.container.stateFlow.collectAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column(
            modifier = Modifier.weight(2f)
        ) {
            TextField(
                modifier = Modifier.padding(start = 13.dp, bottom = 8.dp),
                shape = RoundedCornerShape(18.dp),
                singleLine = true,
                value = if (state.peopleAmount > 0) state.peopleAmount.toString()
                else "",
                onValueChange = {
                    val newValue = it.toIntOrNull()
                    newValue?.let { newValueNotNull ->
                        mainViewModel.onEvent(MainScreenEvent.OnPeopleAmountChange(newValueNotNull))
                    }
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.people_hint),
                        color = MaterialTheme.colorScheme.onSecondary,
                        style = MaterialTheme.typography.displayMedium
                    )
                },
                colors = TextFieldDefaults.colors(
                    cursorColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    focusedTextColor = CardTextColor,
                    unfocusedTextColor = CardTextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = MaterialTheme.colorScheme.onSecondary.copy(.3f),
                    focusedContainerColor = MaterialTheme.colorScheme.onSecondary.copy(.6f)
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                textStyle = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Start)
            )
        }

        Image(
            painter = painterResource(id = R.drawable.shashlik),
            contentDescription = null
        )
    }
}