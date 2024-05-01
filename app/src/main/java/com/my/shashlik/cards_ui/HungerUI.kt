package com.my.shashlik.cards_ui


import android.view.LayoutInflater
import android.widget.SeekBar
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.shashlickcompose.R
import com.my.shashlik.hunger_l
import com.my.shashlik.hunger_m
import com.my.shashlik.hunger_none
import com.my.shashlik.hunger_s
import com.my.shashlik.res_hunger
import com.my.shashlik.ui.theme.CardTextColor


// Hunger
@Composable
fun ChoseHungerUI() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Text(
            text = stringResource(R.string.choose_hunger),
            modifier = Modifier
                .padding(top = 5.dp, start = 13.dp, end = 13.dp),
            color = CardTextColor,
            style = MaterialTheme.typography.titleMedium
        )

        AndroidView(
            modifier = Modifier
                .fillMaxWidth(),
            factory = { context ->
                val view = LayoutInflater.from(context)
                    .inflate(R.layout.hunger_layout, null, false)
                var sbHunger = view.findViewById<SeekBar>(R.id.sbHunger)

                val dr0 = AppCompatResources.getDrawable(context, R.drawable.face_f1)
                sbHunger.thumb = dr0

                sbHunger.height
                sbHunger.setOnSeekBarChangeListener(object :
                    SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                        if (i in 0..24) {

                            val dr1 =
                                AppCompatResources.getDrawable(context, R.drawable.face_f1)
                            sbHunger.thumb = dr1
                            res_hunger = hunger_none

                        } else if (i in 25..49) {
                            val dr2 =
                                AppCompatResources.getDrawable(context, R.drawable.face_f2)
                            sbHunger.thumb = dr2
                            res_hunger = hunger_s

                        } else if (i in 50..74) {
                            val dr3 =
                                AppCompatResources.getDrawable(context, R.drawable.face_f3)
                            sbHunger.thumb = dr3
                            res_hunger = hunger_m

                        } else if (i in 75..100) {
                            val dr4 =
                                AppCompatResources.getDrawable(context, R.drawable.face_f4)
                            sbHunger.thumb = dr4
                            res_hunger = hunger_l

                        }
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar) {}
                    override fun onStopTrackingTouch(seekBar: SeekBar) {}
                })

                // do whatever you want...
                view // return the view
            },
            update = { view ->
                // Update the view
            }
        )
    }
}



