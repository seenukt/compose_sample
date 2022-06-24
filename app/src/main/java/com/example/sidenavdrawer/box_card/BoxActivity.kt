package com.example.sidenavdrawer.box_card

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.sidenavdrawer.box_card.ui.theme.SideNavDrawerTheme

class BoxActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SideNavDrawerTheme {
                val data by remember {
                    mutableStateOf((1..20).map {
                        "item $it"
                    })
                }
                val scrollState = rememberScrollState()
//                Box(modifier = Modifier.fillMaxWidth().height(LocalConfiguration.current.screenHeightDp.dp)) {
//                    ConstraintLayout(
//                        modifier = Modifier
//                            .padding(bottom = 50.dp).fillMaxWidth()
//                            .background(Color.Black)
//                    ) {
//                        val (title, innerConstraint) = createRefs()
//
//                        Text(
//                            text = "Element Using Box",
//                            color = Color.White,
//                            fontSize = 20.sp,
//                            modifier = Modifier.constrainAs(title) {
//                                top.linkTo(parent.top, margin = 20.dp)
//                                start.linkTo(parent.start)
//                                end.linkTo(parent.end)
//                            })
//
//                        Column(
//                            modifier = Modifier
//                                .padding(top = 0.dp)
//                                .constrainAs(innerConstraint) {
//                                    top.linkTo(title.bottom, margin = 50.dp)
//                                    start.linkTo(parent.start)
//                                    end.linkTo(parent.end)
//                                }
//                                .clip(RoundedCornerShape(20.dp))
//                                .fillMaxWidth()
//                                .background(color = Color.White)
//                        ) {
//                            Column(
//                                modifier = Modifier
//                                    .fillMaxSize()
//                                    .verticalScroll(scrollState)
//                            ) {
//                                data.forEach { display ->
//
//                                    Text(
//                                        text = display,
//                                        modifier = Modifier.padding(10.dp),
//                                        color = Color.Black
//                                    )
//
//                                }
//
////                                Card(modifier = Modifier
////                                    .padding(bottom = 30.dp)
////                                    .fillMaxWidth()
////                                    .height(100.dp)
////                                    .shadow(3.dp, shape = RoundedCornerShape(20.dp))) {
////
////                                }
//
//
//                            }
//                        }
//                    }
//                }

                Column(modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(16.dp)) {
                    data.forEach { display ->

                        Text(
                            text = display,
                            modifier = Modifier.padding(10.dp),
                            color = Color.Black
                        )

                    }
                    Card(
                        modifier = Modifier
                            .padding(bottom = 30.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                    ) {

                    }

                }
            }
        }
    }
}

