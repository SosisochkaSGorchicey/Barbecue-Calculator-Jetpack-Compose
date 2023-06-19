package com.my.shashlik

import android.content.Context
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.shashlickcompose.R
import com.my.shashlik.cards_ui.*
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
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(text) {
                    top.linkTo(parent.top)
                }
                .padding(top = 10.dp, start = 20.dp, end = 20.dp),
            textAlign = TextAlign.Center,
            color = Color.White,
            style = TextStyle(fontFamily = getTitleFont()),
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
            backgroundColor = Color.White
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
            backgroundColor = Color.White
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
            backgroundColor = Color.White
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
            backgroundColor = Color.White
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