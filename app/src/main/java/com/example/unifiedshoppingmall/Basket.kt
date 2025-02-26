package com.example.unifiedshoppingmall

import android.R.attr.bottom
import android.R.attr.onClick
import androidx.compose.foundation.border
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
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
            composable("screen1"){ BasketFirstPage(navController = navController, itemList = BasketItems)}
        }
    }
}

@Composable
fun BasketFirstPage(
    modifier: Modifier = Modifier,
    navController: NavController,
    itemList : List<BasketProduct>
){
    val text: String = "장바구니 화면입니다. 장바구니에 담긴 상품들을 조회할 수 있습니다. 결제를 원하시면 아래의 결제하기 버튼을 눌러주세요."
    var total: Int = 0

    for (item in itemList){
        total += item.price * item.num
    }

    val totalString:String = "%,d".format(total)
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier
            .height(10.dp))
        Notification(text = text)
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
            modifier = Modifier
                .fillMaxWidth()
        ){
            AppText(text = "${totalString}원 결제하기")
        }
        Box(modifier = Modifier.weight(0.9f)){
            LazyColumn(
                contentPadding = PaddingValues(bottom = 150.dp),
                modifier = Modifier
                    .fillMaxSize()){
                items(itemList){
                    Spacer(modifier = Modifier
                        .height(10.dp))
                    ItemOfBasket(
                        name = it.name,
                        option = it.option,
                        shop = it.shop,
                        score = it.score,
                        price = it.price,
                        num = it.num,
                        eta = it.eta
                    )
                }
            }
        }
        Box(modifier = Modifier.weight(0.1f)){

        }
    }
}


// BasketItemList
@Composable
fun ItemOfBasket(
    name: String,
    option: String = "",
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
            fontSize = 30.sp,
            modifier = Modifier.padding(
                horizontal = 15.dp,
                vertical = 15.dp
            )
        )
        AppText(
            text = "옵션 : ${option}",
            fontSize = 20.sp,
            modifier = Modifier.padding(
                horizontal = 15.dp,
                vertical = 5.dp
            )
        )
        AppText(
            text = "구매처 : ${shop}",
            fontSize = 20.sp,
            modifier = Modifier.padding(
                horizontal = 15.dp,
                vertical = 5.dp
            )
        )
        AppText(
            text = "평점 : ${score}",
            fontSize = 20.sp,
            modifier = Modifier.padding(
                horizontal = 15.dp,
                vertical = 5.dp
            )
        )
        AppText(
            text = eta,
            fontSize = 20.sp,
            modifier = Modifier.padding(
                horizontal = 15.dp,
                vertical = 5.dp
            )
        )
        AppText(
            text = "가격 : ${formatPrice}원 · ${num}개 (총 ${formatTotal}원)",
            fontSize = 20.sp,
            modifier = Modifier.padding(
                horizontal = 15.dp,
                vertical = 5.dp
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
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
                Text("개수변경")
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
                Text("취소")
            }
        }

    }
}