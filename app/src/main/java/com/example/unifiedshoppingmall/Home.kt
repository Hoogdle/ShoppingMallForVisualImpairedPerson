package com.example.unifiedshoppingmall

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.unifiedshoppingmall.ui.theme.MainBlue

class Home: ViewModel() {

}

@Composable
@Preview
fun UpperNotification(
    modifier: Modifier = Modifier
){
    var text by remember { mutableStateOf("") }

    Scaffold(

    ){
        contentPadding ->
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(contentPadding)
            .padding(4.dp))
        {
            Text(
                text = "안내\n홈 화면입니다. 상품 검색, 카테고리 별 상품 조회, 인기 상품을 확인할 수 있습니다.",
                modifier = Modifier.border(
                    border = BorderStroke(width = 2.dp, color = MainBlue),
                    shape = RectangleShape)
                    .padding(6.dp),
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.main_bold))
            )

            OutlinedTextField(
                value = text,
                onValueChange = {text = it},
                label = { Text(
                    text = "검색",
                    fontFamily = FontFamily(Font(R.font.main_bold)),
                    fontSize = 40.sp
                )},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp)

            )


        }
    }

}