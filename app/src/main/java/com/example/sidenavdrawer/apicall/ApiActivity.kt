package com.example.sidenavdrawer.apicall

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.sidenavdrawer.Model.PostsModelRes
import com.example.sidenavdrawer.apicall.ui.theme.SideNavDrawerTheme
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ApiActivity : ComponentActivity(), KoinComponent {

    private val vm: ApiViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val postList = remember {
                mutableStateOf(value = listOf<PostsModelRes>())
            }
            SideNavDrawerTheme {

                setObserver(postList)


                LazyColumn(modifier = Modifier.padding(top = 10.dp)) {
                    items(postList.value) { data ->
                        Column(
                            modifier = Modifier
                                .padding(
                                    start = 20.dp,
                                    end = 10.dp,
                                    bottom = 5.dp
                                ).fillMaxWidth()
                                .border(
                                    width = 1.dp,
                                    color = Color.Gray,
                                    shape = RoundedCornerShape(10.dp)
                                ).padding(10.dp)
                        ) {
                            Text(text = data.id.toString())
                            Spacer(modifier = Modifier.height(5.dp))
                            Text(text = data.userId.toString())

                        }
                    }
                }
            }
        }
    }

    private fun setObserver(postList: MutableState<List<PostsModelRes>>) {
        vm.post.observe(this) { data ->
            postList.value = data
        }
    }

    override fun onResume() {
        super.onResume()
        vm.getPost()
    }
}
