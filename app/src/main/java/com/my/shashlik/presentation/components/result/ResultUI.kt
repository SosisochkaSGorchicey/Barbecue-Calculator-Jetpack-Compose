package com.my.shashlik.presentation.components.result

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shashlickcompose.R
import com.my.shashlik.res_meat
import com.my.shashlik.res_people
import com.my.shashlik.ui.theme.CardTextColor
import com.my.shashlik.ui.theme.DarkButton

@Composable
fun ResultUI() {
    Row() {
        Card(
            modifier = Modifier
                .weight(1f)
                .padding(start = 20.dp, end = 8.dp, bottom = 8.dp)
                .alpha(0.95f),
            shape = RoundedCornerShape(40),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )

        ) {


            Text(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(start = 13.dp),
                text = "result.value",
                color = CardTextColor,
                style = MaterialTheme.typography.titleMedium
            )

        }



        Button(
            modifier = Modifier
                .wrapContentWidth()
                .wrapContentHeight(Alignment.CenterVertically)
                .padding(end = 20.dp, bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = DarkButton),
            shape = RoundedCornerShape(40),
            onClick = {
                if (res_meat == 0.0 || res_people == 0) {
//                        Toast.makeText(
//                            context,
//                            R.string.toast,
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        result.value = res_text
                } else if (res_people <1 || res_people >50) {
//                        result.value = res_text
//                        Toast.makeText(
//                            context,
//                            R.string.toast_people,
//                            Toast.LENGTH_SHORT
//                        ).show()
                } else {
//                        var helper = (res_people.toDouble()*(res_meat + res_time + res_hunger))
//                        helper = (helper*100).roundToInt() / 100.0
//                        result.value = "$res_text $helper $kilo"
                }
            },
        ) {
            Text(
                text = stringResource(R.string.count),
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
            )

        }

    }
}