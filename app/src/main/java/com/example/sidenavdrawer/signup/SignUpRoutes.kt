package com.example.sidenavdrawer.signup

sealed class SignUpRoutes(val id:String){
    object SignUp:SignUpRoutes(id = "sign_up")
    object Login:SignUpRoutes(id ="log_in")
    object DashBoard:SignUpRoutes(id ="dash_board")

}
