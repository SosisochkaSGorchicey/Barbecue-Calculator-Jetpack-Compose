package com.my.shashlik.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.shashlickcompose.R
import com.my.shashlik.presentation.components.CardElement
import com.my.shashlik.presentation.components.Header
import com.my.shashlik.presentation.components.chooseMeat.ChooseMeatUI
import com.my.shashlik.presentation.components.choosePeople.ChoosePeopleUI
import com.my.shashlik.presentation.components.chooseTime.ChooseTimeUI

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Header()

            CardElement(titleTextRes = R.string.choose_meat) {
                ChooseMeatUI()
            }

            CardElement(titleTextRes = R.string.choose_people) {
                ChoosePeopleUI()
            }

            CardElement(titleTextRes = R.string.choose_time) {
                ChooseTimeUI()
            }
        }

        Header() //.padding(top = 20.dp)
    }
}