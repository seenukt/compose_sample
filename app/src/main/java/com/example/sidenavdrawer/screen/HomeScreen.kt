package com.example.sidenavdrawer.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sidenavdrawer.R

@Composable
fun HomeScreen() {
    val name = remember {
        mutableStateOf("")
    }
    var isError by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.blue))
            .fillMaxSize()
            .padding(vertical = 30.dp)
    ) {
        TextField(colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent, cursorColor = Color.Blue
        ),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                autoCorrect = true,
                keyboardType = KeyboardType.Phone
            ),
            value = name.value,
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxWidth()
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(10.dp)),
            onValueChange = { name.value = it },
            shape = RoundedCornerShape(10.dp),
            singleLine = true,
            placeholder = {
                Text(
                    text = "Enter Full Name ", color = Color.White
                )
            },
            leadingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 30.dp, end = 30.dp)
                        .width(20.dp)
                        .height(20.dp)
                )
            },
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = "",
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                )
            })

        Button(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 40.dp), onClick = {
                name.value = ""
            }, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Cyan
            )
        ) {
            Text(text = "clear text", color = Color.Blue)
        }

        OutlinedTextField(
            value = name.value,
            onValueChange = {
                name.value = it
                isError = false
            }, trailingIcon = {
                if(isError) (
                              Icon(imageVector = Icons.Filled.Close, contentDescription ="error", tint = MaterialTheme.colors.error )
                )
            },
            label = {
                Text(
                    text = "Outline Text Field"
                )
            },
            placeholder = { Text(text = "Enter Name ") },
            modifier = Modifier.padding(top = 20.dp),
            isError = isError
        )
        if (isError) {
            Text(text = "Enter the value")
        }
        Button(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 40.dp), onClick = {
                isError = name.value.isEmpty()
            }, colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Cyan
            )
        ) {
            Text(text = "validate Error", color = Color.Blue)
        }

    }


}