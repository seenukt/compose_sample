package com.example.sidenavdrawer.apicall.repo

import com.example.sidenavdrawer.Model.PostsModelRes
import com.example.sidenavdrawer.apicall.ApiViewModel
import com.example.sidenavdrawer.apicall.apiinterface.ApiInterface
import retrofit2.Response

class PostsRepo(private val apiInterFace:ApiInterface) {

    suspend fun getAllPost(): Response<List<PostsModelRes>> {
      return  apiInterFace.getPost()
    }


}