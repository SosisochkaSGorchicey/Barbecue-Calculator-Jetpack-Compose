package com.my.shashlik.cards_ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shashlickcompose.R
import com.my.shashlik.getMainFont
import com.my.shashlik.getTitleFont
import com.my.shashlik.res_people
import com.my.shashlik.ui.theme.CardTextColor
import com.my.shashlik.ui.theme.CardTextColorHint
import com.my.shashlik.ui.theme.NoColor


// People
@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ChosePeopleUI() {
    val keyboardController = LocalSoftwareKeyboardController.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier
            .weight(2f)
        ) {

            Text(
                text = stringResource(R.string.choose_people),
                modifier = Modifier
                    .padding(top = 5.dp, start = 13.dp, end = 13.dp, bottom = 8.dp),
                color = CardTextColor,
                fontSize = 18.sp,
                style = TextStyle(fontFamily = getTitleFont())
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

                    placeholder   = {
                        Text(
                            text = stringResource(id = R.string.people_hint),
                            color = CardTextColorHint,
                            fontSize = 16.sp,
                            style = TextStyle(fontFamily = getMainFont())
                        )
                    },
                    colors = TextFieldDefaults.colors(
//                        cursorColor = CardTextColor,
//                        textColor = CardTextColor,
//                        focusedIndicatorColor = NoColor,
//                        unfocusedIndicatorColor = NoColor
                    ),
                    shape = RoundedCornerShape(23.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = {keyboardController?.hide()})

                )



        }
        Column(modifier = Modifier
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
