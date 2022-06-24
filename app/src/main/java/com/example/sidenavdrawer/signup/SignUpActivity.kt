package com.example.sidenavdrawer.signup

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.example.sidenavdrawer.ui.theme.SideNavDrawerTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SideNavDrawerTheme {
                val navController = rememberNavController()
                SigUpNavHost(navController = navController, context = LocalContext.current)
            }
        }
    }
}
