package com.example.unifiedshoppingmall

import android.R.attr.text
import androidx.annotation.Size
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppText(
    text: String = "",
    fontSize: TextUnit = 25.sp,
    modifier:Modifier = Modifier.padding(15.dp),
    textAlign: TextAlign? = null
){
    Text(
        text = text,
        fontSize = fontSize,
        fontFamily = FontFamily(Font(R.font.main_bold)),
        color = Color.White,
        modifier = modifier,
        textAlign = textAlign
    )
}