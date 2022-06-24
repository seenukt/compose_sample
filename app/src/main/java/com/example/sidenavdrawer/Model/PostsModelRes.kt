package com.example.sidenavdrawer.Model

import com.google.gson.annotations.SerializedName

data class PostsModelRes(
    @SerializedName("userId") val userId: Int? =null,
    @SerializedName("id") val id: Int? =null,
    @SerializedName("title") val title: String? =null,
    @SerializedName("body") val body: String? =null
)