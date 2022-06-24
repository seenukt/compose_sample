package com.example.sidenavdrawer


import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun Toolbar(toggleClick: () -> Unit) {
    TopAppBar(title = {
        Text(text = stringResource(id = R.string.app_name))
    }, navigationIcon = {
        IconButton(onClick = { toggleClick() }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "menu")
        }
    },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary
    )
}