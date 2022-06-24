package com.example.sidenavdrawer.Routes

sealed class NavScreens(val name: String) {
    object Home : NavScreens("home")
    object Setting : NavScreens("setting")
    object Help : NavScreens("help?id={id}/{test}") {
        //        /{passedData}/{sendData}
//        fun data(content: String, secondValue: String): String {
//            return "help/$content/$secondValue"
//
        fun data(content: String = "seenu"): String {
            return "help?id=$content/seenu"
        }
    }
    object Profile : NavScreens("profile")
}