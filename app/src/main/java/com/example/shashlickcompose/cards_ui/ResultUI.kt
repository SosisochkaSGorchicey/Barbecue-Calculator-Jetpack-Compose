package com.example.shashlickcompose.cards_ui


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shashlickcompose.*
import com.example.shashlickcompose.R
import com.example.shashlickcompose.ui.theme.CardTextColor
import com.example.shashlickcompose.ui.theme.DarkButton
import kotlin.math.roundToInt


@Composable
fun GetResultUI(context: Context) {


    val res_text = stringResource(id = R.string.result)
    val kilo = stringResource(R.string.kilo)
    val result = rememberSaveable {
        mutableStateOf(res_text)
    }

    Row() {
        Card(
            modifier = Modifier
                .height(50.dp)
                .weight(1f)
                .padding(start = 20.dp, end = 8.dp, bottom = 8.dp)
                .alpha(0.95f),
            shape = RoundedCornerShape(15.dp),
            backgroundColor = Color.White
        ) {


            Text(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(start = 13.dp),
                text = result.value,
                color = CardTextColor,
                style = TextStyle(fontFamily = getTitleFont()),
                fontSize = 18.sp,
            )

        }

        Button(
            modifier = Modifier
                .height(50.dp)
                .wrapContentWidth()
                .padding(end = 20.dp, bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = DarkButton),
            shape = RoundedCornerShape(40),
            onClick = {
                if (res_meat == 0.0 || res_people == 0) {
                    Toast.makeText(
                        context,
                        R.string.toast,
                        Toast.LENGTH_SHORT
                    ).show()
                    result.value = res_text
                } else if (res_people<1 || res_people>50) {
                    result.value = res_text
                    Toast.makeText(
                        context,
                        R.string.toast_people,
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    var helper = (res_people.toDouble()*(res_meat+res_time+res_hunger))
                    helper = (helper*100).roundToInt() / 100.0
                    result.value = "$res_text $helper $kilo"
                }
            },
        ) {
            Text(
                text = stringResource(R.string.count),
                style = TextStyle(fontFamily = getTitleFont()),
                color = Color.White,
                fontSize = 18.sp,
            )

        }

    }
}