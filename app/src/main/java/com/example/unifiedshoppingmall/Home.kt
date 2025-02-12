package com.example.unifiedshoppingmall

import android.R.attr.scaleX
import android.R.attr.scaleY
import android.R.attr.text
import android.R.attr.textStyle
import android.R.attr.translationX
import android.R.attr.translationY
import android.icu.text.CaseMap
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.unifiedshoppingmall.ui.theme.MainBlue
import com.example.unifiedshoppingmall.ui.theme.MainBlueDark
import java.nio.file.Files.size


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = Modifier
            .padding(all = 10.dp)
    ) {
        UpperNotification()
        Column(
            modifier = Modifier
                .padding(all = 10.dp)
        ) {
            SearchBar()
        }
    }


}

@Composable
@Preview
fun UpperNotification(
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp))
    {
        Text(
            text = "홈 화면 입니다. 인기 상품과 추천 상품을 조회할 수 있습니다.",
            modifier = Modifier.border(
                border = BorderStroke(
                    width = 4.dp,
                    color = MainBlue),
                shape = RoundedCornerShape(corner = CornerSize(20.dp))
            )
                .padding(6.dp),
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.main_bold))
        )
    }
}


@Composable
fun SearchBar(){
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it},
        label = { Text(
            text = "검색",
            fontFamily = FontFamily(Font(R.font.main_bold)),
            fontSize = 30.sp
        )},
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 2.dp,
                horizontal = 6.dp
            ),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = MainBlue,
            focusedPlaceholderColor = MainBlue,
            focusedContainerColor = Color.White,
            focusedTrailingIconColor = MainBlue,
            unfocusedContainerColor = Color.White,
            focusedSupportingTextColor = MainBlue,
            focusedLabelColor = MainBlue
        ),
        textStyle = TextStyle.Default.copy(fontSize = 30.sp)
    )
}

//@Composable
//fun CategoryButton(
//    modifier: Modifier = Modifier
//){
//    Button(
//        onClick = {/*TODO*/},
//        shape = RoundedCornerShape(5.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 4.dp)
//            .height(95.dp)
//            .padding(vertical = 5.dp),
//        colors = ButtonColors(
//            containerColor = MainBlue,
//            contentColor = Color.White,
//            disabledContainerColor = MainBlue,
//            disabledContentColor = Color.White),
//        ){
//        Text(
//            text = "카테고리 목록",
//            fontSize = 40.sp,
//            fontFamily = FontFamily(Font(R.font.main_bold))
//        )
//    }
//}



@Composable
fun PinchToZoomView(
    modifier: Modifier,
) {
    // Mutable state variables to hold scale and offset values
    var scale by remember { mutableStateOf(1f) }
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    val minScale = 1f
    val maxScale = 4f

    // Remember the initial offset
    var initialOffset by remember { mutableStateOf(Offset(0f, 0f)) }

    // Coefficient for slowing down movement
    val slowMovement = 0.5f

    // Box composable containing the image
    Box(
        modifier = modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { _, pan, zoom, _ ->
                    // Update scale with the zoom
                    val newScale = scale * zoom
                    scale = newScale.coerceIn(minScale, maxScale)

                    // Calculate new offsets based on zoom and pan
                    val centerX = size.width / 2
                    val centerY = size.height / 2
                    val offsetXChange = (centerX - offsetX) * (newScale / scale - 1)
                    val offsetYChange = (centerY - offsetY) * (newScale / scale - 1)

                    // Calculate min and max offsets
                    val maxOffsetX = (size.width / 2) * (scale - 1)
                    val minOffsetX = -maxOffsetX
                    val maxOffsetY = (size.height / 2) * (scale - 1)
                    val minOffsetY = -maxOffsetY

                    // Update offsets while ensuring they stay within bounds
                    if (scale * zoom <= maxScale) {
                        offsetX = (offsetX + pan.x * scale * slowMovement + offsetXChange)
                            .coerceIn(minOffsetX, maxOffsetX)
                        offsetY = (offsetY + pan.y * scale * slowMovement + offsetYChange)
                            .coerceIn(minOffsetY, maxOffsetY)
                    }

                    // Store initial offset on pan
                    if (pan != Offset(0f, 0f) && initialOffset == Offset(0f, 0f)) {
                        initialOffset = Offset(offsetX, offsetY)
                    }
                }
            }
            .pointerInput(Unit) {
                detectTapGestures(
                    onDoubleTap = {
                        // Reset scale and offset on double tap
                        if (scale != 1f) {
                            scale = 1f
                            offsetX = initialOffset.x
                            offsetY = initialOffset.y
                        } else {
                            scale = 2f
                        }
                    }
                )
            }
            .graphicsLayer {
                scaleX = scale
                scaleY = scale
                translationX = offsetX
                translationY = offsetY
            }
    ) {
        // Image to be displayed with pinch-to-zoom functionality
        HomeScreen()
    }
}