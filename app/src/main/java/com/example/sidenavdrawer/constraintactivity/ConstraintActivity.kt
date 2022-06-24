package com.example.sidenavdrawer.constraintactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.sidenavdrawer.constraintactivity.ui.theme.SideNavDrawerTheme

class ConstraintActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scrollableState = rememberScrollState()
            SideNavDrawerTheme {
                Column(modifier = Modifier
                    .background(color = Color.Gray)
                    .fillMaxSize()
                ){
                    ConstraintLayout(modifier = Modifier.verticalScroll(scrollableState)) {
                        val (name, eMail, box) = createRefs()
                        Text(
                            text = "mladldmdmdmdldldmd",
                            modifier = Modifier

                                .constrainAs(name) {
                                    top.linkTo(parent.top, margin = 700.dp)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                }
                                .padding(end = 20.dp, start = 20.dp)
                                .border(width = 2.dp, color = Color.Black)
                                .fillMaxWidth()
                                .padding(10.dp),
                            color = Color.Black,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium, textAlign = TextAlign.Center
                        )

                        Text(
                            text = "Half way ",
                            modifier = Modifier
                                .constrainAs(eMail) {
                                    top.linkTo(name.bottom, margin = 10.dp)
                                    start.linkTo(parent.start)
                                    end.linkTo(parent.end)
                                    bottom.linkTo(parent.bottom, margin = 20.dp)
                                }
                                .padding(start = 20.dp, end = 20.dp)
                                .shadow(
                                    3.dp,
                                    shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                                )
                                .fillMaxWidth()
                                .background(Color.Green)
                                .padding(start = 30.dp, top = 30.dp, bottom = 20.dp)
                        )

                    }
                }
            }
        }
    }
}


