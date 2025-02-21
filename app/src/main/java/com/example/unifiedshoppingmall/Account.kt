package com.example.unifiedshoppingmall

import SearchwithVocie
import android.R.attr.text
import android.accounts.Account
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.unifiedshoppingmall.ui.theme.MainBlue

data class OrderedProduct(
    val name: String,
    val eta: String,
    val price: Int,
    val number: Int
)

val OrderedProductList: List<OrderedProduct> = listOf(
    OrderedProduct(name = "삼성 무선 마우스 키보드 KBW-1234", eta = "배송완료, 1월 17일(금) 도착", price = 12560, number = 2),
    OrderedProduct(name = "애플 맥북 Pro M2", eta = "배송완료, 1월 30일(금) 도착", price = 2500000, number = 1),
    OrderedProduct(name = "애플망고 30개입 세트", eta = "배송중, 7월 21일(금) 도착", price = 24000, number = 2),
    )

@Composable
fun Account(){
    val navController = rememberNavController()

    Column {
        NavHost(navController = navController, startDestination = "screen1") {
            composable("screen1"){ AccountFirstPage(navController = navController)}
            composable("registerAccount"){ AccountRegister(navController = navController)}
            composable("selectShoppingMall"){ InterfaceSetting(navController = navController)}
            composable("settingInterface"){ InterfaceSetting(navController = navController)}
            composable("OrderedList"){ OrderedList(navController = navController, itemList = OrderedProductList) }
        }
    }
}

@Composable
fun AccountFirstPage(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val text: String = "계정설정 화면입니다. 계정등록, 쇼핑몰 선택, 인터페이스 변경을 선택할 수 있습니다."

    Column {
        Spacer(modifier = Modifier
            .height(10.dp))
        Notification(
            text = text)
        Spacer(modifier = Modifier
            .height(10.dp))
        Button(
            onClick = {
                navController.navigate("registerAccount")
            },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth()
        ){
            AppText(text = "계정등록")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate("OrderedList")
            },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth()
        ){
            AppText(text = "주문목록")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate("OrderedList")
            },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth()
        ){
            AppText(text = "취소·반품·교환 목록")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate("settingInterface")
            },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth()
        ){
            AppText(text = "할인쿠폰")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate("settingInterface")
            },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth()
        ){
            AppText(text = "인터페이스 설정")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate("settingInterface")
            },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth()
        ){
            AppText(text = "고객센터")
        }
    }
}

@Composable
fun AccountRegister(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val text: String = "계정등록 화면입니다. 쿠팡, 네이버쇼핑, G마켓 계정을 등록하거나 수정할 수 있습니다. 쇼핑몰 계정을 등록하여 해당 쇼핑몰의 상품 정보를 조회할 수 있습니다."

    Column {
        Spacer(modifier = Modifier
            .height(10.dp))
        Notification(
            text = text)
        Spacer(modifier = Modifier
            .height(10.dp))
        Button(
            onClick = {
            },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth()
        ){
            AppText(text = "쿠팡(활성화)")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
            },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth()
        ){
            AppText(text = "네이버쇼핑(비활성화)")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
            },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth()
        ){
            AppText(text = "G마켓(비활성화)")
        }
    }
}

@Composable
fun OrderedList(
    modifier: Modifier = Modifier,
    navController: NavController,
    itemList: List<OrderedProduct>
){
    val text: String = "상품 주문 목록입니다. 주문하신 상품을 조회, 변경, 취소 하실 수 있습니다."

    Column {
        Spacer(modifier = Modifier
            .height(10.dp))
        Notification(text = text)
        LazyColumn(
            contentPadding = PaddingValues(bottom = 150.dp),
            modifier = Modifier.fillMaxSize()){
            items(itemList){
                Spacer(modifier = Modifier
                    .height(10.dp))
                ItemOfOrderedList(
                    productName = it.name,
                    eta = it.eta,
                    price = it.price,
                    number = it.number
                )
            }
        }
    }
}

@Composable
fun InterfaceSetting(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val text: String = "인터페이스 설정 화면입니다. 고대비 테마, 글꼴 크기를 설정할 수 있습니다."

    Column {
        Spacer(modifier = Modifier
            .height(10.dp))
        Notification(
            text = text)
        Spacer(modifier = Modifier
            .height(10.dp))
        Button(
            onClick = {
            },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth()
        ){
            AppText(text = "고대비 설정")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
            },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier.fillMaxWidth()
        ){
            AppText(text = "글꼴 크기 설정")
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

// OrderedList Template
@Composable
fun ItemOfOrderedList(
    productName : String,
    eta: String,
    price: Int,
    number: Int
){
    var total = price * number
    val formatPrice = "%,d".format(price)
    val formatTotal = "%,d".format(total)

    Column(modifier = Modifier
        .border(width = 5.dp, color = MainBlue, shape = RectangleShape)){
        AppText(
            text = productName,
            fontSize = 25.sp)
        AppText(
            text = eta,
            fontSize = 20.sp)
        AppText(
            text = "가격 : ${formatPrice}원 · ${number}개 (총 ${formatTotal}원)",
            fontSize = 20.sp
        )
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround){
            Button(
                shape = RectangleShape,
                onClick = {},
                colors = ButtonColors(
                    containerColor = MainBlue,
                    contentColor = Color.White,
                    disabledContainerColor = MainBlue,
                    disabledContentColor = Color.White),
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
            ){
                Text("상품정보")
            }
            Button(
                shape = RectangleShape,
                onClick = {},
                colors = ButtonColors(
                    containerColor = MainBlue,
                    contentColor = Color.White,
                    disabledContainerColor = MainBlue,
                    disabledContentColor = Color.White),
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
            ){
                Text("교환·반품")
            }
            Button(
                shape = RectangleShape,
                onClick = {},
                colors = ButtonColors(
                    containerColor = MainBlue,
                    contentColor = Color.White,
                    disabledContainerColor = MainBlue,
                    disabledContentColor = Color.White),
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp)
            ){
                Text("배송조회")
            }
        }

    }
}