package com.example.shashlickcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.content.ContextCompat
import com.example.shashlickcompose.ui.theme.ShashlickComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.main)

        super.onCreate(savedInstanceState)

        setContent {
            ShashlickComposeTheme {
                MainLayout(this)
            }
        }
    }

}

