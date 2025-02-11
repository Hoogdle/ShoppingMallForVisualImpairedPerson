package com.example.unifiedshoppingmall

import android.R.attr.label
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unifiedshoppingmall.ui.theme.UnifiedShoppingMallTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val navItemList = listOf(
            NavItem(label = "장바구니", icon = Icons.Default.ShoppingCart),
            NavItem(label = "홈", icon = Icons.Default.Home),
            NavItem(label = "환경설정", icon = Icons.Default.Settings)
        )
        setContent {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    NavigationBar {
                        navItemList.forEachIndexed { index, navItem ->
                            NavigationBarItem(
                                selected = true,
                                onClick = {},
                                icon = {
                                    Icon(imageVector = navItem.icon, contentDescription = null)
                                },
                                label = {
                                    Text(text = navItem.label)
                                }
                            )
                        }

                    }
                }
            ) { innerPadding ->
                UpperNotification(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}


@Composable
fun ContentScreen(
    modifier: Modifier = Modifier
){

}
