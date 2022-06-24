package com.example.sidenavdrawer

import android.widget.Toast
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sidenavdrawer.Model.NavItemModel
import com.example.sidenavdrawer.Routes.NavScreens
import kotlinx.coroutines.launch
import kotlinx.coroutines.selects.select

@Composable
fun ManinScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            Toolbar {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        },
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,
        drawerContent = {
            HeaderScreen()
            NaveItem(
                lists = listOf(
                    NavItemModel("home", "Home", Icons.Default.Home),
                    NavItemModel("setting", "Settings", Icons.Default.Settings),
                    NavItemModel("help", "Help", Icons.Default.Call),
                    NavItemModel("profile", "Profile", Icons.Default.Close)
                ), click = { item ->
                    scope.launch {
                        scaffoldState.drawerState.close()
                    }
//                    if( state?.destination?.route != item.id) {
                        when (item.id) {
                            "home" -> {
                                navController.navigate(NavScreens.Home.name) {
                                    launchSingleTop = true
                                }
                            }
                            "setting" -> {
                                navController.navigate(NavScreens.Setting.name){
                                    launchSingleTop = true
                                }

                            }
                            "help" -> {
                                navController.navigate(NavScreens.Help.data("ss")) {
                                    launchSingleTop = true
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                }
                            }
                            "profile" -> {
                                navController.navigate(NavScreens.Profile.name){
                                    launchSingleTop = true
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                }
                            }
                        }
//                    }
                }
            )
        }) {
        SideNaveGraph(navController, LocalContext.current)
    }

}