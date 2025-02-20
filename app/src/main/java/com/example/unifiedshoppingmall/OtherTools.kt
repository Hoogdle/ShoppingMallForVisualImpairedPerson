package com.example.unifiedshoppingmall

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppText(
    text: String = ""
){
    Text(
        text = text,
        fontSize = 25.sp,
        fontFamily = FontFamily(Font(R.font.main_bold)),
        color = Color.White,
        modifier = Modifier.padding(15.dp)
    )
}