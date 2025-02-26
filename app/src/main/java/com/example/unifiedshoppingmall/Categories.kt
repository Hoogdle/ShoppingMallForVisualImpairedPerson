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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
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
import androidx.compose.ui.graphics.colorspace.WhitePoint
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
val householdItems: CategoryItem = CategoryItem(name = "생활용품", itemList = listOf("헤어","바디/세안","구강/면도","화장지/물티슈","생리대/성인용기저귀","기저귀","세탁세제","청소/주방세제","탈취/방향/살충","건강/의료용품","성인용품(19)","세탁/청소용품","욕실용품","생활전기용품","수납/정리","주방수납/잡화","생활잡화","공구/철물/DIY","안전/호신용품"))
val interior: CategoryItem = CategoryItem(name = "홈인테리어", itemList = listOf("가구","침구샵","수납/정리","욕실용품","세탁/청소용품","침구","카페트/쿠션/거실화","커튼/블라인드","수예/수선","홈데코","조명/스탠드","원예/가드닝","셀프인테리어","공구/철물/DIY","생활전기용품","안전/호신용품","싱글하우스"))
val digitalAppliance: CategoryItem = CategoryItem(name = "가전디지털", itemList = listOf("TV/영상가전","냉장고","세탁기/건조기","생활가전","청소기","계절가전","뷰티/헤어가전","건강가전","주방가전","노트북","데스크탑","모니터","휴대폰","테블릿PC","스마트워치/밴드","게임","키보드/마우스","저장장치","프린터/복합기","PC부품","PC주변기기","음향기기","카메라","전동킥보드/자전거","차량용 디지털","1인방송 전문관","휴대폰 악세서리"))
val sports: CategoryItem = CategoryItem(name = "스포츠/레저", itemList = listOf("캠핑전문관","홈트레이닝","수영/수상스포츠","골프","자전거","킥보드/스케이트","낚시","등산/아웃도어","스포츠신발","남성스포츠의류","여성스포츠의류","유아스포츠의류","스포츠잡화","구기스포츠","라켓스포츠","헬스/요가/댄스","복싱/검도/태권도","기타스포츠","스키/겨울스포츠"))
val autoSupplies: CategoryItem = CategoryItem(name = "자동차용품", itemList = listOf("봄철 차량관리","인테리어","익스테리어","세차/카케어","차량용 전자기기","차량관리/소모품","RV/아웃도어","부품/안전/공구","오토바이용품"))
val booksMusicsDvds: CategoryItem = CategoryItem(name = "도서/음반/DVD", itemList = listOf("유아/어린이","소설/에세이/시","초중고참고서","가정/살림","건강/취미","경제/경영","과학/공학","국어/외국어/사전","대학교재","만화/라이트노벨","사회/정치","수험서/자격증","여행","역사","예술","인문","자기계발","잡지","종교","청소년","해외도서","IT/컴퓨터","CD/LP","DVD/블루레이"))
val toys: CategoryItem = CategoryItem(name = "완구/취미", itemList = listOf("캐릭터별완구","신생아/영아완구","로봇/작동완구","역할놀이","블록놀이","인형","물놀이/계절완구","승용완구","스포츠/야외완구","실내대형완구","STEAM완구","학습완구/교구","보드게임","RC완구/부품","퍼즐/큐브/피젯토이","프라모델","피규어/다이캐스트","콘솔/휴대용게임기","파티/마술도구","DIY","악기/음향기기","원예/가드닝","수집품","연령별완구","키덜트샵"))
val stationery: CategoryItem = CategoryItem(name = "문구/오피스", itemList = listOf("미술/화방용품","캐릭터 문구","학용품/수업준비","필기류","노트/메모지","다이어리/플래너","바인더/파일","파티/이벤트","데코/포장용품","카드/엽서/봉투","앨범","복사용품/라벨지","보드/칠판/광고",))
val petSupplies: CategoryItem = CategoryItem(name = "반려동물용품", itemList = listOf("강아지 사료","강아지 간식","강아지 영양제","강아지 용품","고양이 사료","고양이 간식","고양이 영양제","고양이 용품","펫티켓 산책용품","관상어 용품","소동물/가축용품"))
val health: CategoryItem = CategoryItem(name = "헬스/건강식품", itemList = listOf("건강기능식품","성인용 건강식품","여성용 건강식품","남성용 건강식품","임산부 건강식품","시니어 건강식품","어린이 건강식품","비타민/미네랄","건강식품","허브/식물추출물","홍삼/인삼","꿀/프로폴리스","건강분말/건강환","헬스보충식품","다이어트/이너뷰티","홈트레이닝","헬스/요가용품","건강가전","건강도서","건강/의료용품"))


val categoryItems: List<CategoryItem> = listOf(fashion,beauty,baby,foods,kitchen,householdItems,interior,digitalAppliance,sports,autoSupplies,booksMusicsDvds,toys,stationery,petSupplies,health)

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
        contentPadding = PaddingValues(bottom = 100.dp),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(150.dp)
            .fillMaxHeight()
            .background(Color.Black)
    ) {
        itemsIndexed(categoryItems){
        index, item ->
        Spacer(modifier = Modifier.height(3.dp))
        Button(
            onClick = {
            selectedIndex = index
            onItemClick(selectedIndex)
        },
            colors = ButtonColors(
                containerColor = MainBlue,
                contentColor = Color.White,
                disabledContainerColor = MainBlue,
                disabledContentColor = Color.White
            ),
            shape = RectangleShape,
            modifier = Modifier
                .fillMaxWidth(),
        )
        {
            AppText(
                fontSize = 20.sp,
                text = item.name,
                modifier = Modifier.padding(5.dp).fillMaxWidth(),
                textAlign = TextAlign.Left,
            )
        }
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


