package com.example.sidenavdrawer.bottomnav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.lifecycle.OnLifecycleEvent
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sidenavdrawer.bottomnav.ui.theme.SideNavDrawerTheme

class BottomNavActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val color =  remember { mutableStateOf(android.R.color.black) }

            SideNavDrawerTheme {
                this.window.statusBarColor = color.value
                val navController = rememberNavController()
                val list = listOf(
                    BottomNavRoutes.DashBoard,
                    BottomNavRoutes.Setting,
                    BottomNavRoutes.Profile,
                    BottomNavRoutes.FriendList
                )

                Scaffold(bottomBar = {
                    BottomNavigation(
                        backgroundColor = colorResource(id = android.R.color.holo_blue_light),
                        contentColor =
                        Color.White

                    ) {
                        val backStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = backStackEntry?.destination?.route
                        list.forEach { item ->
                            BottomNavigationItem(
                                onClick = {
                                    navController.navigate(item.routes) {
                                        launchSingleTop = true
                                        if (item.routes == BottomNavRoutes.FriendList.routes)  window.statusBarColor = ContextCompat.getColor(this@BottomNavActivity ,android.R.color.holo_blue_dark) else window.statusBarColor = ContextCompat.getColor(this@BottomNavActivity ,android.R.color.darker_gray)
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
//                                            if (item.routes == BottomNavRoutes.FriendList.routes)  inclusive = true
                                        }
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = item.tile
                                    )
                                },
                                label = {
                                    Text(text = item.tile)
                                }, selectedContentColor = Color.White,
                                unselectedContentColor = Color.White.copy(0.4f),
                                selected = currentDestination == item.routes,
                                alwaysShowLabel = false
                            )
                        }
                    }
                }) {
                    BottomNavHost(navController)
                }
            }
        }
    }
}
