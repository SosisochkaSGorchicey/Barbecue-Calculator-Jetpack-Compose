package com.my.shashlik


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.my.shashlik.presentation.MainScreen
import com.my.shashlik.ui.theme.ShashlickComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShashlickComposeTheme {
                MainScreen()
            }
        }
    }
}

