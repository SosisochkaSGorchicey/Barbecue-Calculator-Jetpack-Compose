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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.shashlickcompose.R
import com.my.shashlik.cards_ui.ChoseHungerUI
import com.my.shashlik.cards_ui.ChoseMeatUI
import com.my.shashlik.cards_ui.ChosePeopleUI
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


        // ***** MAIN TEXT *****
        Text(
            text = stringResource(R.string.title),
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(text) {
                    top.linkTo(parent.top)
                }
                .padding(top = 10.dp, start = 20.dp, end = 20.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge
        )


        // ***** MEAT *****
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.95f)
                .constrainAs(meat) {
                    top.linkTo(text.bottom)
                }
                .padding(top = 10.dp, start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            ChoseMeatUI()
        }


        // ***** PEOPLE *****
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(people) {
                    top.linkTo(meat.bottom)
                }
                .alpha(0.95f)
                .padding(top = 18.dp, start = 20.dp, end = 20.dp),
            shape = RoundedCornerShape(25.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {
            ChosePeopleUI()
        }


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