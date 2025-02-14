package com.example.unifiedshoppingmall

import android.R.attr.scaleX
import android.R.attr.scaleY
import android.R.attr.text
import android.R.attr.textStyle
import android.R.attr.translationX
import android.R.attr.translationY
import android.icu.text.CaseMap
import android.util.Log.w
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.Alignment
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

val p1 = Product(name = "A", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p2 = Product(name = "B", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p3 = Product(name = "C", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p4 = Product(name = "D", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p5 = Product(name = "E", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p6 = Product(name = "F", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p7 = Product(name = "G", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p8 = Product(name = "H", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p9 = Product(name = "I", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p10 = Product(name = "J", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p11 = Product(name = "K", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p12 = Product(name = "L", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")
val p13 = Product(name = "M", price = " 12,500원", review = "4.5", shop = "쿠팡", deliveryDate = "내일 오전")


val productList = listOf<Product>(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13)

@Composable
fun Home(
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

    val scrollState = rememberScrollState()

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
        Column(
            modifier = Modifier
                .padding(all = 15.dp)
        ) {
            UpperNotification()
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
            ) {
                SearchBar()
                PopularProducts(modifier = Modifier, productList)
                RecommendProducts(modifier = Modifier, productList)
            }
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
            modifier = Modifier
                .border(
                border = BorderStroke(
                    width = 4.dp,
                    color = MainBlue),
                shape = RoundedCornerShape(corner = CornerSize(20.dp))
            )
                .padding(6.dp),
            fontSize = 30.sp,
            fontFamily = FontFamily(Font(R.font.main_bold)),
            color = Color.White
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

@Composable
fun PopularProducts(
    modifier: Modifier = Modifier,
    Products: List<Product>
){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(
            horizontal = 6.dp,
            vertical = 6.dp
        ),
    ){
        Box(
            modifier = Modifier
                .background(MainBlue)
                .height(50.dp)
                .fillMaxWidth()
        ){
            Text(
                text = "인기상품",
                fontFamily = FontFamily(Font(R.font.main_bold)),
                fontSize = 30.sp,
                color = Color.White
            )
        }
        LazyRow(){
            items(items = Products){ item ->
                Column(modifier = Modifier
                    .clickable(onClick = {})
                    .border(
                        width = 5.dp,
                        color = MainBlue,
                        shape = RectangleShape
                    )
                    .size(width = 150.dp, height = 250.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = item.name,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.main_bold)),
                        fontSize = 30.sp
                    )
                    Text(
                        text = item.price,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.main_bold)),
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}

@Composable
fun RecommendProducts(
    modifier: Modifier = Modifier,
    Products: List<Product>
){
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(
            horizontal = 6.dp,
            vertical = 6.dp
        ),
    ){
        Box(
            modifier = Modifier
                .background(MainBlue)
                .height(50.dp)
                .fillMaxWidth()
        ){
            Text(
                text = "추천상품",
                fontFamily = FontFamily(Font(R.font.main_bold)),
                fontSize = 30.sp,
                color = Color.White
            )
        }
        LazyRow(){
            items(items = Products){ item ->
                Column(modifier = Modifier
                    .clickable(onClick = {})
                    .border(
                        width = 5.dp,
                        color = MainBlue,
                        shape = RectangleShape
                    )
                    .size(width = 150.dp, height = 250.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = item.name,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.main_bold)),
                        fontSize = 30.sp
                    )
                    Text(
                        text = item.price,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.main_bold)),
                        fontSize = 30.sp
                    )
                }
            }
        }
    }
}




