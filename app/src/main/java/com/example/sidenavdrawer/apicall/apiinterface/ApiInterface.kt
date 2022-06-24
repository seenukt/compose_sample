package com.example.sidenavdrawer.apicall.apiinterface

import com.example.sidenavdrawer.Model.PostsModelRes
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    suspend fun getPost():Response<List<PostsModelRes>>
}