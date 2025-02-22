package com.example.unifiedshoppingmall

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unifiedshoppingmall.ui.theme.MainBlue


data class BasketProduct(
    val name: String,
    val option: String,
    val shop: String,
    val score: String,
    val price: Int,
    val num: Int,
    val eta: String
)

val BasketItems: List<BasketProduct> = listOf(
    BasketProduct(
        name = "3색 네임펜",
        option = "블랙",
        shop = "쿠팡",
        score = "4.7",
        price = 3000,
        num = 2,
        eta = "4월 14일(금) 예정"
    ),
    BasketProduct(
        name = "3M 귀마개",
        option = "노란색",
        shop = "쿠팡",
        score = "3.5",
        price = 7500,
        num = 1,
        eta = "3월 11일(금) 예정"
    ),
    BasketProduct(
        name = "페브리즈 Air",
        option = "상쾌한 향",
        shop = "쿠팡",
        score = "4.9",
        price = 5200,
        num = 1,
        eta = "3월 12일(토) 예정"
    )
)

@Composable
fun Basket(){
    val navController = rememberNavController()

    Column {
        NavHost(navController = navController, startDestination = "screen1") {
            composable("screen1"){ BasketFirstPage(navController = navController)}
        }
    }
}

@Composable
fun BasketFirstPage(
    modifier: Modifier = Modifier,
    navController: NavController
){
    val text: String = "장바구니 화면입니다. 장바구니에 담긴 상품들을 조회할 수 있습니다. 결제를 원하시면 최하단의 결제하기 버튼을 눌러주세요."

    Column {
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        Notification(
            text = text
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
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
        ) {
            AppText(text = "계정등록")
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
        ) {
            AppText(text = "주문목록")
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
        ) {
            AppText(text = "취소·반품·교환 목록")
        }
    }
}


// BasketItemList
@Composable
fun ItemOfBasket(
    name: String,
    option: String,
    shop: String,
    score: String,
    price: Int,
    num: Int,
    eta: String
){
    var total = price * num
    val formatPrice = "%,d".format(price)
    val formatTotal = "%,d".format(total)

    Column(modifier = Modifier
        .border(width = 5.dp, color = MainBlue, shape = RectangleShape)){
        AppText(
            text = name,
            fontSize = 25.sp)
        AppText(
            text = eta,
            fontSize = 20.sp)
        AppText(
            text = "가격 : ${formatPrice}원 · ${num}개 (총 ${formatTotal}원)",
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