package com.example.unifiedshoppingmall

import SearchwithVocie
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun Search(){
    Column(
        modifier = Modifier
            .padding(vertical = 20.dp)
    ){
        SearchNotification()
        SearchwithVocie()
    }
}

@Composable
@Preview
fun SearchNotification(
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp))
    {
        Text(
            text = "검색화면 입니다. 아래의 검색란에 원하는 상품을 입력해주세요.",
            modifier = Modifier
                .border(
                    border = BorderStroke(
                        width = 4.dp,
                        color = MainBlue),
                    shape = RoundedCornerShape(corner = CornerSize(20.dp))
                )
                .padding(15.dp),
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.main_bold)),
            color = Color.White
        )
    }
}