package com.my.shashlik.cards_ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shashlickcompose.R
import com.my.shashlik.res_time
import com.my.shashlik.time_l_type
import com.my.shashlik.time_m_type
import com.my.shashlik.time_s_type
import com.my.shashlik.ui.theme.BackgroundColor
import com.my.shashlik.ui.theme.CardTextColor

@Composable
fun ChoseTimeUI() {

    Column {

        Text(
            text = stringResource(R.string.choose_length),
            modifier = Modifier
                .padding(top = 5.dp, start = 13.dp, end = 13.dp),
            color = CardTextColor,
            style = MaterialTheme.typography.titleMedium
        )

        val time_s = stringResource(R.string.length_s)
        val time_m = stringResource(R.string.length_m)
        val time_l = stringResource(R.string.length_l)

        val chosenTime = rememberSaveable {
            mutableStateOf(0.0)
        }
        res_time = chosenTime.value

        val timesOptions = listOf(time_s, time_m, time_l)
        val (selectedOption, onOptionSelected) = rememberSaveable { mutableStateOf(timesOptions[0]) }

        if (selectedOption==time_s) chosenTime.value = time_s_type
        else if (selectedOption==time_m) chosenTime.value = time_m_type
        else if (selectedOption==time_l) chosenTime.value = time_l_type

        Column(Modifier.selectableGroup()) {
            timesOptions.forEach { text ->



                Row(
                    modifier = if (text == time_l) {
                        Modifier.padding(bottom = 8.dp)
                    } else {
                        Modifier.padding(bottom = 0.dp)
                    },
                    verticalAlignment = Alignment.CenterVertically,
                )
                {
                    RadioButton(
                        modifier = Modifier.size(40.dp),
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
//                            if (text==time_s) chosenTime.value = time_s_type
//                            else if (text==time_m) chosenTime.value = time_m_type
//                            else if (text==time_l) chosenTime.value = time_l_type
                        },
                        colors = RadioButtonDefaults.colors(BackgroundColor)
                    )

                    Text(
                        modifier = Modifier.wrapContentHeight(),
                        text = text,
                        style = MaterialTheme.typography.displayMedium
                    )
                }
            }
        }
    }
}
