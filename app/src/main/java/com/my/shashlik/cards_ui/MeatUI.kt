package com.my.shashlik.cards_ui


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.shashlickcompose.R
import com.my.shashlik.chicken_meat_type
import com.my.shashlik.cow_meat_type
import com.my.shashlik.pig_meat_type
import com.my.shashlik.res_meat
import com.my.shashlik.sheep_meat_type
import com.my.shashlik.ui.theme.CardTextColor


@Composable
fun ChoseMeatUI() {
    Column() {

        Text(
            text = stringResource(R.string.choose_meat),
            modifier = Modifier
                .padding(top = 5.dp, start = 13.dp, end = 13.dp),
            color = CardTextColor,
            style = MaterialTheme.typography.titleMedium
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            val alphaMax = 1.0F
            val alphaMin = 0.38F



            val chosenMeat = rememberSaveable {
                mutableStateOf(0.0)
            }

            val alphaCow = rememberSaveable {
                mutableStateOf(alphaMax)
            }

            val alphaChicken = rememberSaveable {
                mutableStateOf(alphaMax)
            }

            val alphaPig = rememberSaveable {
                mutableStateOf(alphaMax)
            }

            val alphaSheep = rememberSaveable {
                mutableStateOf(alphaMax)
            }


            res_meat = chosenMeat.value




            // COW
            Image(
                painter = painterResource(id = R.drawable.cow),
                contentDescription = "cow",
                modifier = Modifier
                    .size(70.dp)
                    .alpha(alphaCow.value)
                    .clickable(
                        enabled = true,
                        onClick = {
                            alphaCow.value = alphaMax
                            alphaChicken.value = alphaMin
                            alphaPig.value = alphaMin
                            alphaSheep.value = alphaMin
                            chosenMeat.value = cow_meat_type
                        }
                    )


            )


            //CHICKEN
            Image(
                painter = painterResource(id = R.drawable.chicken),
                contentDescription = "chicken",
                modifier = Modifier
                    .size(70.dp)
                    .alpha(alphaChicken.value)
                    .clickable(
                        enabled = true,
                        onClick = {
                            alphaCow.value = alphaMin
                            alphaChicken.value = alphaMax
                            alphaPig.value = alphaMin
                            alphaSheep.value = alphaMin
                            chosenMeat.value = chicken_meat_type
                        }
                    )

            )


            // PIG
            Image(
                painter = painterResource(id = R.drawable.pig),
                contentDescription = "pig",
                modifier = Modifier
                    .size(70.dp)
                    .alpha(alphaPig.value)
                    .clickable(
                        enabled = true,
                        onClick = {
                            alphaCow.value = alphaMin
                            alphaChicken.value = alphaMin
                            alphaPig.value = alphaMax
                            alphaSheep.value = alphaMin
                            chosenMeat.value = pig_meat_type
                        }
                    )

            )

            // SHEEP
            Image(
                painter = painterResource(id = R.drawable.sheep),
                contentDescription = "sheep",
                modifier = Modifier
                    .size(70.dp)
                    .alpha(alphaSheep.value)
                    .clickable(
                        enabled = true,
                        onClick = {
                            alphaCow.value = alphaMin
                            alphaChicken.value = alphaMin
                            alphaPig.value = alphaMin
                            alphaSheep.value = alphaMax
                            chosenMeat.value = sheep_meat_type
                        }
                    )

            )
        }
    }
}
