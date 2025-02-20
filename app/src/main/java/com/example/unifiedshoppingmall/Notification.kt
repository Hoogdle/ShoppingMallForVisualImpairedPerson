package com.example.unifiedshoppingmall

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifiedshoppingmall.ui.theme.MainBlue

@Composable
fun Notification(
    modifier: Modifier = Modifier,
    text: String,
    productName: String = ""
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp))
    {
        Text(
            text = text,
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = 4.dp,
                        color = MainBlue),
                    shape = RoundedCornerShape(corner = CornerSize(20.dp))
                )
                .padding(15.dp),
            fontSize = 25.sp,
            fontFamily = FontFamily(Font(R.font.main_bold)),
            color = Color.White
        )
    }
}