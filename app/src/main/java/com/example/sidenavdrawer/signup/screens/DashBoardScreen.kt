package com.example.sidenavdrawer.signup.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.example.sidenavdrawer.Model.Spots
import com.example.sidenavdrawer.Model.TamilNaduStates

@Composable
fun DashBoardScreen(navController: NavHostController, context: Context) {

    NestedLazyColumn(
        listOf(
            TamilNaduStates(
                "Erode",
                listOf(
                    Spots("Thalavadi"),
                    Spots("Bargur"),
                    Spots("Bannari Amman temple"),
                    Spots("velode bird sanctuary")
                )
            ),
            TamilNaduStates(
                "Namakkal",
                listOf(
                    Spots("Koli Hills"),
                    Spots("Anjaneray temple "),
                    Spots("seeku parai view"),
                    Spots("narsimar temple")
                )
            ),
            TamilNaduStates(
                "Dharmapuri",
                listOf(
                    Spots("hogenakkal falls"),
                    Spots("cs Garden "),
                    Spots("melagiri hills"),
                    Spots("narsimar temple")
                )
            )
            ,
            TamilNaduStates(
                "Dharmapuri",
                listOf(
                    Spots("hogenakkal falls"),
                    Spots("cs Garden "),
                    Spots("melagiri hills"),
                    Spots("narsimar temple")
                )
            ),
            TamilNaduStates(
                "Dharmapuri",
                listOf(
                    Spots("hogenakkal falls"),
                    Spots("cs Garden "),
                    Spots("melagiri hills"),
                    Spots("narsimar temple")
                )
            ),
            TamilNaduStates(
                "Dharmapuri",
                listOf(
                    Spots("hogenakkal falls"),
                    Spots("cs Garden "),
                    Spots("melagiri hills"),
                    Spots("narsimar temple")
                )
            ),
            TamilNaduStates(
                "Dharmapuri",
                listOf(
                    Spots("hogenakkal falls"),
                    Spots("cs Garden "),
                    Spots("melagiri hills"),
                    Spots("narsimar temple")
                )
            )

        )
    ) {
        Toast.makeText(context, it.location, Toast.LENGTH_SHORT).show()


    }
}


@Composable
fun NestedLazyColumn(
    districtList: List<TamilNaduStates>?,
    clicked: (data: Spots) -> Unit
) {

    Column(
        modifier = Modifier
            .padding( 20.dp)
    ) {
        LazyColumn(modifier = Modifier.border(
            border = BorderStroke(
                2.dp,
                Color.Blue
            ), shape = RoundedCornerShape(20.dp)
        ).fillMaxSize().padding(10.dp).border(
            border = BorderStroke(
                2.dp,
                Color.Magenta
            ), shape = RoundedCornerShape(20.dp)
        ).padding(30.dp) ) {
            districtList?.let { districtList ->

                items(districtList) { data ->
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = data.districtName,
                            color = Color.Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic
                        )
                        data.touristSpots.forEach { spots ->
                            Text(
                                text = " ◦ ${spots.location}",
                                modifier = Modifier
                                    .padding(start = 30.dp)
                                    .clickable {
                                        clicked(spots)
                                    }
                            )
                        }
                    }
                }
            }
        }
    }
}
