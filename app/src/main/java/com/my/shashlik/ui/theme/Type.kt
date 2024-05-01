package com.my.shashlik.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

val Typography = Typography(
    titleMedium = TextStyle(
        fontFamily = titleFont,
        fontSize = 18.sp,
        lineHeight = 22.sp,
        textAlign = TextAlign.Start
    ),
    titleLarge = TextStyle(
        fontFamily = titleFont,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        textAlign = TextAlign.Center
    ),
    displayMedium = TextStyle(
        fontFamily = mainFont,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        textAlign = TextAlign.Start
    )
)