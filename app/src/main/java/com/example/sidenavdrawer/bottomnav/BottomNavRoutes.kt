package com.example.sidenavdrawer.bottomnav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavRoutes( val routes:String,val icon:ImageVector,val tile:String ){
    object  DashBoard:BottomNavRoutes("dash_board",Icons.Default.Home,"Home")
    object  Setting:BottomNavRoutes("settings",Icons.Default.Settings,"Setting")
    object  Profile:BottomNavRoutes("profile",Icons.Default.Favorite,"Profile")
    object  FriendList:BottomNavRoutes("friend_list",Icons.Default.Face,"Friend List")
}

