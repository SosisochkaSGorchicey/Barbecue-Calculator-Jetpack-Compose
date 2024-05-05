package com.my.shashlik

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.my.shashlik.cards_ui.ChoseHungerUI
import com.my.shashlik.cards_ui.ChoseTimeUI
import com.my.shashlik.cards_ui.GetResultUI
import com.my.shashlik.ui.theme.BackgroundColor


@Composable
fun ConstraintLayoutContent(context: Context) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .verticalScroll(rememberScrollState())
    ) {

        val (text, meat, people, time, hunger, resultCard) = createRefs()

        // ***** TIME *****
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(time) {
                    top.linkTo(people.bottom)
                }
                .alpha(0.95f)
                .padding(top = 18.dp, start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            ChoseTimeUI()
        }


        // ***** HUNGER *****
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.95f)
                .padding(top = 18.dp, start = 20.dp, end = 20.dp, bottom = 18.dp)
                .constrainAs(hunger) {
                    top.linkTo(time.bottom)
                },
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            ChoseHungerUI()
        }


        // ***** RESULT *****
        Row(
            modifier = Modifier
                .constrainAs(resultCard) {
                    linkTo(top = hunger.bottom, bottom = parent.bottom, bias = 1.0f)
                },
            verticalAlignment = Alignment.Bottom
        ) {
            GetResultUI(context)
        }
    }
}