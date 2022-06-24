package com.example.sidenavdrawer.bottomnav

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun  BottomNavHost( navHostController: NavHostController){
    NavHost(navController = navHostController , startDestination = BottomNavRoutes.DashBoard.routes){
        composable(BottomNavRoutes.DashBoard.routes){
             Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                 Text(text = "DashBoard Screen")
             }
        }
        composable(BottomNavRoutes.Setting.routes){
            SettingScreen2()
        }
        composable(BottomNavRoutes.Profile.routes){
            Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
                Text(text = "Profile Screen")
            }
        }
        composable(BottomNavRoutes.FriendList.routes){
            Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
                Text(text = "Friend list  Screen")
            }
        }
    }
}

@Composable
fun SettingScreen2 () {
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Text(text = "Setting  Screen", modifier = Modifier.clickable {

        })
    }
}

