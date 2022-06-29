package com.example.sidenavdrawer.classic_android_compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.sidenavdrawer.R

class ClassicComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            val radioOptions = listOf("Java", "Kotlin", "html", "css", ".net")

            val (selectedOptions, onOptionSelected) = remember {
                mutableStateOf(radioOptions[0])
            }
            val interactionSource  =  remember {
                MutableInteractionSource()
            }

            val switchChecked = remember {
                mutableStateOf(false)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Column {
                    radioOptions.forEach { text ->

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(width = 1.dp, color = Color.Blue),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(colors = RadioButtonDefaults.colors(unselectedColor = Color.Cyan),
                                selected = text == selectedOptions,
                                onClick = { onOptionSelected(text) },
                                modifier = Modifier
                                    .padding(10.dp)
                                    .width(20.dp)
                                    .height(20.dp)
                                    .selectable(
                                        selected = (text == selectedOptions),
                                        onClick = { onOptionSelected(text) }
                                    )
                            )
                            Text(
                                text = text,
                                modifier = Modifier
                                    .padding(start = 10.dp, top = 0.dp)
                                    .clickable(indication = null, interactionSource =interactionSource ){}
                                    .selectable(
                                        selected = (text == selectedOptions),
                                        onClick = { onOptionSelected(text) }
                                    )

                            )
                        }
                    }

                    Switch(
                        checked = switchChecked.value,
                        onCheckedChange = {
                            switchChecked.value = it
                            Toast.makeText(
                                this@ClassicComposeActivity,
                                it.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        colors = SwitchDefaults.colors(
                            checkedThumbColor = Color.Blue,
                            checkedTrackColor = Color.Blue,
                            checkedTrackAlpha = 0.3f
                        )
                    )

                    Checkbox(
                        checked = switchChecked.value,
                        onCheckedChange = {
                            switchChecked.value = it
                            Toast.makeText(
                                this@ClassicComposeActivity,
                                it.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                    )

                    CustomSwitch()
// ------------custom check box
                    val checked = remember {
                        mutableStateOf(false)
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Box(
                            modifier = Modifier
                                .padding(start = 20.dp, top = 4.dp)
                                .clickable(indication = null,interactionSource = interactionSource) {
                                    checked.value = !checked.value
                                }
                                .clip(CircleShape)
                                .size(20.dp)
                                .background(Color.Green)
                                .padding(1.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                                .padding(1.3.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            if (checked.value) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_tick),
                                    contentDescription = ""
                                )
                            }
                        }
                        Text(text = "n,sdlsmklsmldwmsdlslmlslkmdklslklslslslslslslslsllslslslslsllslslslslslslsllkzllzllzllxs", modifier = Modifier
                            .padding(start = 10.dp, top = 0.dp)
                            .clickable(interactionSource = interactionSource, indication = null) {
                                checked.value = !checked.value
                            })


                    }
                }

//
//                    Switch2()

//                    val items = (0..1)
//                    var activeTabIndex by remember { mutableStateOf(0) }
//
//                    TabRow(
//                        selectedTabIndex = activeTabIndex, backgroundColor = Color.Transparent,
//                        indicator = {
//                            Box(
//                                Modifier
//                                    .tabIndicatorOffset(it[activeTabIndex])
//                                    .fillMaxSize()
//                                    .background(color = Color.Cyan)
//                                    .zIndex(-1F)
//                            )
//                        },
//                    ) {
//                        items.mapIndexed { i, item ->
//                            Tab(selected = activeTabIndex == i, onClick = { activeTabIndex = i }) {
//                                Icon(
//                                    painter = painterResource(id = someIcon),
//                                    contentDescription = null,
//                                    tint = Color.Black,
//                                    modifier = Modifier.padding(vertical = 20.dp)
//                                )
//                            }
//                        }
//                    }
            }
        }
    }

    @Composable
    private fun CustomSwitch() {
        val switchState = remember {
            mutableStateOf(false)
        }
        val animatePosition = animateFloatAsState(
            targetValue = if (switchState.value)
                with(LocalDensity.current) { (40.dp).toPx() }
            else
                with(LocalDensity.current) { (10.dp).toPx() }
        )

        Canvas(modifier = Modifier
            .padding(start = 30.dp)
            .width(50.dp)
            .height(20.dp)
            .background(
                color = if (switchState.value) Color.Gray else Color.White,
                shape = RoundedCornerShape(10.dp)
            )
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    switchState.value = !switchState.value
                })
            }) {

            drawRoundRect(
                color = Color.Green,
                cornerRadius = CornerRadius(x = 25.dp.toPx(), y = 25.dp.toPx()),
                style = Stroke(width = 2.dp.toPx()),
            )

            drawCircle( color = Color.Magenta, center = Offset(
                x = animatePosition.value,
                y = size.height/2
            ), radius = size.height/2 - 10 )


        }


        // compose view existing xml

//        val composeView = findViewById<ComposeView>(R.id.compose_view)
//        composeView.apply {
//            setContent {
//                Text(text = "ajjajaja")
//            }
//        }
    }
}
//@Composable
//fun Switch2(
//    scale: Float = 2f,
//    width: Dp = 36.dp,
//    height: Dp = 20.dp,
//    strokeWidth: Dp = 2.dp,
//    checkedTrackColor: Color = Color(0xFF35898F),
//    uncheckedTrackColor: Color = Color(0xFFe0e0e0),
//    gapBetweenThumbAndTrackEdge: Dp = 4.dp
//) {
//
//    val switchON = remember {
//        mutableStateOf(true) // Initially the switch is ON
//    }
//
//    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge
//
//    // To move thumb, we need to calculate the position (along x axis)
//    val animatePosition = animateFloatAsState(
//        targetValue = if (switchON.value)
//            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
//        else
//            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() }
//    )
//
//    Canvas(
//        modifier = Modifier.padding(start = 20.dp)
//            .size(width = width, height = height)
//            .scale(scale = scale)
//            .pointerInput(Unit) {
//                detectTapGestures(
//                    onTap = {
//                        // This is called when the user taps on the canvas
//                        switchON.value = !switchON.value
//                    }
//                )
//            }
//    ) {
//        // Track
//        drawRoundRect(
//            color = if (switchON.value) checkedTrackColor else uncheckedTrackColor,
//            cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx()),
//            style = Stroke(width = strokeWidth.toPx()),
//        )
//
//        // Thumb
//        drawCircle(
//            color = if (switchON.value) checkedTrackColor else uncheckedTrackColor,
//            radius = thumbRadius.toPx(),
//            center = Offset(
//                x = animatePosition.value,
//                y = size.height / 2
//            )
//        )
//    }
//
//    Spacer(modifier = Modifier.height(18.dp))
//
//    Text(text = if (switchON.value) "ON" else "OFF")
//}
