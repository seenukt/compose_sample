package com.example.sidenavdrawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sidenavdrawer.Model.NavItemModel

@Composable
@Preview
fun HeaderScreen() {
    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.dark_blue))
            .fillMaxWidth()
            .padding(vertical = 50.dp)
    ) {

        Column {
            Image(painterResource(R.drawable.ic_launcher_background),"" )
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = stringResource(id = R.string.header), fontSize = 30.sp)
            Text(text = stringResource(id = R.string.header), fontSize = 30.sp)
        }

    }
}

@Composable
fun NaveItem(
    lists: List<NavItemModel>,
    click: (NavItemModel) -> Unit
) {
    LazyColumn(Modifier) {
        items(lists) { list ->
            Row(modifier = Modifier
                .padding(1.dp)
                .background(colorResource(id = R.color.blue))
                .fillMaxWidth()
                .clickable {
                    click(list)
                }
                .padding(10.dp)
            ) {
                Icon(imageVector = list.image, contentDescription = null)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = list.title, modifier = Modifier.weight(1f))
            }
        }
    }
}