package com.example.unifiedshoppingmall

import android.R.attr.data
import android.R.attr.fontFamily
import android.R.attr.height
import android.R.attr.name
import android.R.attr.text
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifiedshoppingmall.leftList
import com.example.unifiedshoppingmall.ui.theme.MainBlue


class CategoryItem(name : String, itemList: List<String>){
    val name: String
    val itemList: List<String>
    init{
        this.name = name
        this.itemList = itemList
    }
}
val fashion: CategoryItem = CategoryItem(name = "패션", itemList = listOf("여성패션", "남성패션", "남녀 공용 의류", "속옷 / 잠옷", "유아동패션"))
val beauty: CategoryItem = CategoryItem(name = "뷰티", itemList = listOf("스킨케어", "클린/비건뷰티", "클렌징", "메이크업", "향수", "남성화장품", "네일", "뷰티소품", "어린이 화장품", "헤어", "바디", "선물세트 / 키트"))
val baby: CategoryItem = CategoryItem(name = "출산/유아동", itemList = listOf("유아동패션", "기저귀", "물티슈", "분유/어린이식품", "어린이 건강식품","수유용품","이유용품/유아식기","매트/안전용품","유모차/웨건","카시트","아기띠/외출용품","욕실용품/스킨케어","위생/건강/세제","유아동침구","유아가구/인테리어","완구/교구","유아동도서","출산준비물/선물","임부/태교용품"))
val foods: CategoryItem = CategoryItem(name = "식품", itemList = listOf("과일","견과/건과","채소","쌀/잡곡","축산/계란","수산물/건어물","생수/음료","커피/원두/차","과자/초콜릿/시리얼","면/통조림/가공식품","가루/조미료/오일","장/소스/드레싱/식초","유제품/아이스크림","냉장/냉동/간편요리","건강식품","분유/어린이식품","반찬/간편식/대용식"))
val kitchen: CategoryItem = CategoryItem(name = "주방용품", itemList = listOf("냄비/프라이팬","주방조리도구","그릇/홈세트","수저/커트러리","컵/텀블러/와인용품","주전자/커피/티용품","주방수납/정리","밀폐저장/도시락","주방잡화","일회용품/종이컵","보온/보냉용품","1인가구 주방용품","주방가전"))


val categoryItems: List<CategoryItem> = listOf(fashion,beauty,baby,foods,kitchen)

//data class CategoryItems(
//    val fashion: List<String>
//    = listOf<String>("여성패션", "남성패션", "남녀 공용 의류", "속옷 / 잠옷", "유아동패션"),
//    val beauty: List<String>
//    = listOf<String>("스킨케어", "클린/비건뷰티", "클렌징", "메이크업", "향수", "남성화장품", "네일", "뷰티소품", "어린이 화장품", "헤어", "바디", "선물세트 / 키트"),
//    val forKids: List<String>
//    = listOf<String>("유아동패션", "기저귀", "물티슈", "분유/어린이식품", "수유용품", "이유용품/유아식기", "매트/안전용품", "유모차/웨건", "카시트", "아기띠/외출용품", "욕실용품/스킨케어", "위생/건강/세제", "유아동침구","유아가구/인테리어","완구/교구","유아동도서","출산준비물/선물","임부/태교용품"),
//    val foods: List<String>
//    = listOf<String>("유기농 / 친환경", "과일", "견과/건과", "채소", "쌀 잡곡", "축산/계란", "수산물/건어물", "생수/음료", "커피/원두/차", "과자/초콜릿/시리얼", "면/통조림/가공식품", "가루/조미료/오일", "장/소스/드레싱/식초","유제품/아이스크림", "냉장/냉동/간편요리","건강식품","분유/어린이식품","반찬/간편식/대용식","사과식초/땅콩버터 외"),
//    val kitchenProduct: List<String>,
//    val lifeProduct: List<String>,
//    val houseInterior: List<String>,
//    val houseAppliances: List<String>,
//    val sports: List<String>,
//    val carTools: List<String>,
//    val bookAndMusic: List<String>,
//    val office: List<String>,
//    val pet: List<String>,
//    val health: List<String>
//){
//
//}

@Composable
fun Category(
    modifier: Modifier = Modifier
){
    var selectedItem by remember {
        mutableStateOf(0)
    }

    Column(
        modifier = Modifier
            .padding(vertical = 15.dp)
    ){
        CategoryNotification()
        Row(
        ){
            leftList{ item ->
                selectedItem = item
            }
            rightList(item = selectedItem)
        }
    }

}
@Composable
@Preview
fun CategoryNotification(
    modifier: Modifier = Modifier
){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 4.dp))
    {
        Text(
            text = "카테고리 화면입니다. 원하는 상품 종류를 선택해 주세요. 왼쪽에서 상품 종류를 선택한 후 오른쪽에서 세부 품목을 선택해주세요.",
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


@Composable
fun leftList(
    onItemClick: (selectedIndex: Int) -> Unit
){

    var selectedIndex by remember {
        mutableStateOf(0)
    }

    LazyColumn(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(150.dp)
            .fillMaxHeight()
            .background(MainBlue)
    ) {
        itemsIndexed(categoryItems){
        index, item ->
        Text(
            text = item.name,
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.main_bold)),
            fontSize = 27.sp,
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 2.dp,
                    color = Color.Black,
                    shape = RectangleShape
                )
                .height(60.dp)
                .clickable(
                    enabled = true,
                    onClick = {
                        selectedIndex = index
                        onItemClick(selectedIndex)
                    })
        )
        }
    }
}

@Composable
fun rightList(
    modifier: Modifier = Modifier
        .fillMaxWidth(),
    item: Int
){
    var selectedIndex by remember {
        mutableStateOf(item)
    }
    var selectedRightIndex by remember {
        mutableStateOf(0)
    }

    LazyColumn(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color.Black)
    ) {
        itemsIndexed(categoryItems[item].itemList){
                index, item ->

                Text(
                    text = item,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.main_bold)),
                    fontSize = 23.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 2.dp,
                            color = Color.Black,
                            shape = RectangleShape
                        )
                        .height(60.dp)
                        .clickable(
                            enabled = true,
                            onClick = { selectedRightIndex = index})
                )

        }
    }
}


