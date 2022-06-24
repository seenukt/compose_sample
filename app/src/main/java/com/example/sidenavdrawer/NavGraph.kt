package com.example.sidenavdrawer


import android.content.Context
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.sidenavdrawer.Routes.NavScreens
import com.example.sidenavdrawer.screen.HomeScreen
import com.example.sidenavdrawer.screen.MyTransactionHistory
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SideNaveGraph(navController: NavHostController, context: Context) {
    val scope = rememberCoroutineScope()
    val open = remember {
        mutableStateOf(true)
    }
    NavHost(navController = navController, startDestination = NavScreens.Home.name) {
        composable(route = NavScreens.Home.name) {
            HomeScreen()
//            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                Text(text = "Home   Screen ", Modifier.clickable { open.value = true })
//                D(open)
//            }
        }
        composable(NavScreens.Setting.name) {

//            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
//                Text(text = "Setting  Screen ", Modifier.clickable { open.value = true })
//                D(open)
//            }
            MyTransactionHistory(context)
        }
        composable(NavScreens.Help.name, arguments = listOf(
            navArgument("passedData") {
            this.type = NavType.StringType
            nullable = true
        },
            navArgument("test") {
                this.type = NavType.StringType
            }
        )) { navBackStackEntry ->
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Help  Screen ")
                val bottomSheetScaffold = rememberBottomSheetScaffoldState(
                    bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
                )
                BottomSheetScaffold(
                    scaffoldState = bottomSheetScaffold,
                    sheetContent = {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Bottom Sheet")
                        }
                    },
                    backgroundColor = colorResource(id = R.color.blue),
                    sheetShape = MaterialTheme.shapes.small,
                    modifier = Modifier.pointerInput(Unit) {
                        detectTapGestures(onTap = {
                                scope.launch {
                                    bottomSheetScaffold.bottomSheetState.expand()
                                }
                        })

                    }, sheetGesturesEnabled = true
                ) {

                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                        Button(
                            shape = RoundedCornerShape(10.dp),
                            onClick = {
                                scope.launch {
                                    if (bottomSheetScaffold.bottomSheetState.isCollapsed) {
                                        bottomSheetScaffold.bottomSheetState.expand()
                                    } else {
                                        bottomSheetScaffold.bottomSheetState.collapse()
                                    }
                                }

                            },
                            colors = ButtonDefaults.buttonColors(colorResource(id = android.R.color.holo_orange_light))
                        ) {
                            Text(
                                text = " ${
                                    navBackStackEntry.arguments?.getString("passedData").toString()
                                }+ ${navBackStackEntry.arguments?.getString("test").toString()}"
                            )

                        }

                    }

                }
            }
        }

        composable(NavScreens.Profile.name) {

            val sheetState =
                rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
            val (selected, setSelected) = remember { mutableStateOf(0) }
            ModalBottomSheetLayout(sheetContent = {
                when (selected) {
                    0 -> Layout1()
                    1 -> Layout2()
                }
            }, sheetState = sheetState) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = "Profile  Screen ")
                    Button(
                        onClick = {
                            setSelected(0)
                            scope.launch {
                                sheetState.show()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(colorResource(id = android.R.color.holo_orange_light))
                    ) {
                        Text(text = "First BottomSheet ")
                    }
                    Button(onClick = {
                        setSelected(1)
                        scope.launch {
                            sheetState.show()
                        }
                    }) {
                        Text(text = "Second BottomSheet ")
                    }

                }
//                Content(sheetState, setSelected = setSelected)

            }
        }
    }
}


@Composable
fun D(open: MutableState<Boolean>) {
    if (open.value) {
        AlertDialog(
            onDismissRequest = { open.value = false },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = false),
            title = { Text(text = "Alert") },
            text = { Text(text = "Just alert for check") },
            confirmButton = {
                TextButton(onClick = { open.value = false }) {
                    Text(text = "Continue")
                }
            },
            dismissButton = {
                TextButton(onClick = { open.value = false }) {
                    Text(text = "cancel")
                }
            })
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Content(sheetState: ModalBottomSheetState, setSelected: (Int) -> Unit) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            setSelected(0)
            scope.launch {
                sheetState.show()
            }
        }) {
            Text(text = "Show First")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            setSelected(1)
            scope.launch {
                sheetState.show()
            }
        }) {
            Text(text = "Show Second")
        }
    }
}

@Composable
private fun Layout1() {
    Text(
        modifier = Modifier.padding(16.dp),
        text = "BottomSheetLayout 1"
    )
}

@Composable
private fun Layout2() {
    LazyColumn(
        Modifier
            .fillMaxWidth()
            .height(LocalConfiguration.current.screenHeightDp.dp.div(1))
    ) {
        items(50) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "BottomSheetLayout:$it"
            )
        }
    }
}


