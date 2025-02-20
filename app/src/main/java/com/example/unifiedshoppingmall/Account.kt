package com.example.unifiedshoppingmall

import SearchwithVocie
import android.R.attr.text
import android.accounts.Account
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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


@Composable
fun Account(){
    val navController = rememberNavController()


    val text: String = "계정설정 화면입니다. 계정등록, 쇼핑몰 선택, 인터페이스 변경을 선택할 수 있습니다."

    Column {
        Spacer(modifier = Modifier
            .height(10.dp))
        Notification(
            text = text)
        Spacer(modifier = Modifier
            .height(10.dp))
        NavHost(navController = navController, startDestination = "screen1") {
            composable("screen1"){ AccountFirstPage(navController = navController)}
            composable("registerAccount"){ AccountRegister(navController = navController)}
            composable("selectShoppingMall"){ InterfaceSetting(navController = navController)}
            composable("settingInterface"){ InterfaceSetting(navController = navController)}

        }
    }
}

@Composable
fun AccountFirstPage(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column {
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
            AppText(text = "게정등록")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                navController.navigate("selectShoppingMall")
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
            AppText(text = "쇼핑몰 선택")
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
    }
}

@Composable
fun AccountRegister(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column {
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
fun InterfaceSetting(
    modifier: Modifier = Modifier,
    navController: NavController
){
    Column {
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
            AppText(text = "???")
        }
    }
}
