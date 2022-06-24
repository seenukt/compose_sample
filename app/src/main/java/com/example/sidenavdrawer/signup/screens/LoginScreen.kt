package com.example.sidenavdrawer.signup.screens


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sidenavdrawer.R
import com.example.sidenavdrawer.signup.SignUpRoutes

@Composable
fun Login(navController: NavHostController, context: Context) {
    val email = rememberSaveable {
        mutableStateOf("seenu")
    }
    val isErrorEMail = remember {
        mutableStateOf(false)
    }
    val isErrorPassword = remember {
        mutableStateOf(false)
    }
    val password = remember {
        mutableStateOf("seenu")
    }
    Column(
        modifier = Modifier
            .background(
                color = colorResource(id = R.color.gray)
            )
            .fillMaxSize()
    ) {

        Text(
            text = stringResource(id = R.string.welcome),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 30.dp),
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Divider(
            modifier = Modifier
                .padding(top = 26.dp)
                .width(250.dp)
                .align(alignment = Alignment.CenterHorizontally),
            color = colorResource(id = R.color.lite_gray),
            thickness = 3.dp
        )

        Image(
            painter = painterResource(id = R.drawable.ic_dance),
            contentDescription = "image",
            modifier = Modifier.padding(top = 20.dp)
        )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.padding(top = 10.dp)
        ) {
            OutlinedTextField(
                value = email.value,
                onValueChange = {
                    email.value = it
                    isErrorEMail.value = false
                },
                trailingIcon = {
                    if (isErrorEMail.value) (
                            Icon(
                                painter = painterResource(id = R.drawable.ic_tick) ,
                                contentDescription = "error"
                            )
                            )
                }, maxLines = 1,
                label = {
                    Text(
                        text = " Email Address", color = Color.White
                    )
                },
                placeholder = { Text(text = "Enter Email ") },
                modifier = Modifier
                    .padding(top = 20.dp, start = 50.dp, end = 50.dp)
                    .fillMaxWidth(),
                isError = isErrorEMail.value,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    placeholderColor = Color.White
                ), leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_email_file),
                        contentDescription = "email",
                        modifier = Modifier.padding(end = 10.dp, start = 10.dp)
                    )
                }
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = {
                    password.value = it
                    isErrorPassword.value = false
                },
                trailingIcon = {
                    if (isErrorPassword.value) (
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "error",
                                tint = MaterialTheme.colors.error
                            )
                            )
                },
                label = {
                    Text(
                        text = " Password", color = Color.White
                    )
                },
                placeholder = { Text(text = "Enter Password ") },
                modifier = Modifier
                    .padding(top = 20.dp, start = 50.dp, end = 50.dp)
                    .fillMaxWidth(),
                isError = isErrorPassword.value,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Color.White,
                    focusedIndicatorColor = Color.White,
                    placeholderColor = Color.White
                ), leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_email_file),
                        contentDescription = "email",
                        modifier = Modifier.padding(end = 10.dp, start = 10.dp)
                    )
                },
                maxLines = 1
            )
            Button(
                onClick = {
                    validateTextField(
                        navController,
                        email,
                        password,
                        isErrorPassword,
                        isErrorEMail,
                        context
                    )
                }, modifier = Modifier
                    .padding(top = 20.dp, start = 50.dp, end = 50.dp)
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.lite_gray))
            ) {
                Text(
                    text = stringResource(id = R.string.login),
                    color = Color.White,
                    fontSize = 16.sp
                )
            }
            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(Color.Black)) {
                    append("Don't have an account ? ")
                }
                pushStringAnnotation(
                    tag = "SignUp",// provide tag which will then be provided when you click the text
                    annotation = "SignUp"
                )
                withStyle(style = SpanStyle(Color.White)) {
                    append("Sign Up")
                }
                pop()
            }
            ClickableText(
                text = text, onClick = {
                    text.getStringAnnotations(
                        tag = "SignUp", start = it, end = it
                    )[0].let {
                        navController.navigate(route = SignUpRoutes.SignUp.id)
                    }

                }, modifier = Modifier
                    .padding(top = 20.dp, start = 50.dp, end = 50.dp)
                    .fillMaxWidth()
            )
        }
    }
}

fun validateTextField(
    navController: NavHostController,
    email: MutableState<String>,
    password: MutableState<String>,
    isErrorPassword: MutableState<Boolean>,
    isErrorEMail: MutableState<Boolean>,
    context: Context
) {
    if (email.value.isEmpty()) {
        isErrorEMail.value = true
        return
    }
    if (password.value.isEmpty()) {
        isErrorPassword.value = true
        return
    }

    if (email.value == "seenu" && password.value == "seenu") {
        navController.navigate(SignUpRoutes.DashBoard.id) {
            navController.popBackStack()
        }
    } else {
        Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
    }

}
