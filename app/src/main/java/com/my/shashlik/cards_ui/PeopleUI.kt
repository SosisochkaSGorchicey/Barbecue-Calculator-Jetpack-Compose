package com.my.shashlik.cards_ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.shashlickcompose.R
import com.my.shashlik.res_people
import com.my.shashlik.ui.theme.CardTextColor
import com.my.shashlik.ui.theme.CardTextColorHint


// People
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ChosePeopleUI() {
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .weight(2f)
        ) {

            Text(
                text = stringResource(R.string.choose_people),
                modifier = Modifier
                    .padding(top = 5.dp, start = 13.dp, end = 13.dp, bottom = 8.dp),
                color = CardTextColor,
                style = MaterialTheme.typography.titleMedium
            )

            var peopleValue by rememberSaveable {
                mutableStateOf("")
            }


            TextField(

                modifier = Modifier
                    .padding(start = 13.dp, bottom = 8.dp)
                    .wrapContentHeight(),
                singleLine = true,

                value = peopleValue,
                onValueChange = {
                    peopleValue = it
                    if (it.isNotEmpty()) res_people = it.toInt()
                },

                placeholder = {
                    Text(
                        text = stringResource(id = R.string.people_hint),
                        color = CardTextColorHint,
                        style = MaterialTheme.typography.displayMedium
                    )
                },
                colors = TextFieldDefaults.colors(
//                        cursorColor = CardTextColor,
//                        textColor = CardTextColor,
//                        focusedIndicatorColor = NoColor,
//                        unfocusedIndicatorColor = NoColor
                ),
                shape = RoundedCornerShape(23.dp),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() })

            )


        }
        Column(
            modifier = Modifier
                .weight(1f)
                .height(100.dp)
                .align(Alignment.Bottom),
        ) {
            Image(
                painter = painterResource(id = R.drawable.shashlik),
                contentDescription = "shashlik",
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp, start = 13.dp, end = 13.dp)
            )
        }

    }
}
