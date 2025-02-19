package com.example.unifiedshoppingmall

import android.Manifest
import android.R.attr.fontFamily
import android.R.attr.label
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unifiedshoppingmall.ui.theme.MainBlue
import com.example.unifiedshoppingmall.ui.theme.UnifiedShoppingMallTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        val navItemList = listOf(
            NavItem(label = "홈", icon = Icons.Default.Home),
            NavItem(label = "카테고리", icon = Icons.AutoMirrored.Filled.List),
            NavItem(label = "검색", icon = Icons.Default.Search),
            NavItem(label = "계정", icon = Icons.Default.AccountCircle),
            NavItem(label = "장바구니", icon = Icons.Default.ShoppingCart)
        )
        setContent {



            var selectedIndex by remember{
                mutableStateOf(0)
            }

            Scaffold(
                containerColor = Color.Black,
                modifier = Modifier
                    .fillMaxSize(),
                bottomBar = {
                    NavigationBar(
                        containerColor = Color.Black,) {
                        navItemList.forEachIndexed { index, navItem ->
                            NavigationBarItem(
                                selected = selectedIndex == index,
                                onClick = {
                                    selectedIndex = index
                                },
                                icon = {
                                    Icon(
                                        imageVector = navItem.icon,
                                        contentDescription = null,
                                        modifier = Modifier.size(35.dp),
                                        tint = MainBlue
                                    )
                                },
                                label = {
                                    Text(
                                        text = navItem.label,
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(Font(R.font.main_bold)),
                                        color = Color.White
                                        )
                                },
                            )
                        }

                    }
                }
            ) { innerPadding ->
                ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex)
            }
        }
    }
}


@Composable
fun ContentScreen(
    modifier: Modifier = Modifier,
    seletedIndex: Int,
) {
    when(seletedIndex){
        0 -> Home(modifier = modifier)
        1 -> Category()
        2 -> Search()
        3 -> Account()
        4 -> Basket()
    }
}

