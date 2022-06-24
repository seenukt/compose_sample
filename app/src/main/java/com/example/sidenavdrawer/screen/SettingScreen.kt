package com.example.sidenavdrawer.screen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sidenavdrawer.Model.PostResponseModel

@Composable
fun MyTransactionHistory(context: Context) {
    Column {

        Box(
            modifier = Modifier
                .background(color = colorResource(id = android.R.color.holo_blue_dark))
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .padding(start = 16.dp, top = 10.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .clickable {

                        },
                    tint = Color.White
                )
                Text(
                    text = "Transaction History ",
                    color = Color.White,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
        ListData(
            listOf(
                PostResponseModel(129292992, 1, "jksksksk", ""),
                PostResponseModel(2929929, 2, "jksksksk", ""),
                PostResponseModel(32020202, 3, "jksksksk", ""),
                PostResponseModel(4202002, 4, "jksksksk", ""),
                PostResponseModel(520020, 5, "jksksksk", "")
            ), itemClicked = {
                Toast.makeText(context, it.id.toString(), Toast.LENGTH_SHORT).show()

            })

    }
}

@Composable
fun ListData(
    list: List<PostResponseModel>,
    itemClicked: (click: PostResponseModel) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier.padding(top = 10.dp)) {
        items(list) { data ->
            ListItem(data, itemClicked)

        }
    }
}

@Composable
fun ListItem(data: PostResponseModel, itemClicked: (click: PostResponseModel) -> Unit) {

    Row(
        modifier = Modifier
            .padding(start = 5.dp, bottom = 8.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = colorResource(id = android.R.color.holo_blue_dark),
                RoundedCornerShape(10.dp)
            )
            .clickable {
                itemClicked(data)
            }
    ) {
        Text(text = data.id.toString(), modifier = Modifier.padding(top = 10.dp, start = 10.dp))
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = data.userId.toString(),
            modifier = if (data.id % 2 == 0) {
                Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
                    .background(
                        Color.Red,
                        shape = RoundedCornerShape(5.dp)
                    )
                    .padding(10.dp)
            } else Modifier
                .padding(top = 5.dp, bottom = 5.dp)
                .background(
                    Color.Green,
                    shape = RoundedCornerShape(5.dp)
                )
                .padding(10.dp)
        )

    }
}