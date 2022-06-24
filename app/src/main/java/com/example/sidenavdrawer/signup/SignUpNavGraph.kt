package com.example.sidenavdrawer.signup

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sidenavdrawer.signup.screens.DashBoardScreen
import com.example.sidenavdrawer.signup.screens.Login
import com.example.sidenavdrawer.signup.screens.SignUpScreen

@Composable
fun SigUpNavHost( navController:NavHostController, context:Context){
    
    NavHost(navController = navController, startDestination = SignUpRoutes.Login.id){

        composable(route = SignUpRoutes.Login.id){
            Login(navController,context)
        }
        composable(route = SignUpRoutes.DashBoard.id){
            DashBoardScreen(navController,context)
        }
        composable(route = SignUpRoutes.SignUp.id){
            SignUpScreen(navController,context)
        }
    }
    
}