package com.example.sidenavdrawer.apicall

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sidenavdrawer.Model.PostsModelRes
import com.example.sidenavdrawer.apicall.repo.PostsRepo
import com.example.sidenavdrawer.corutiens.CoroutinesManager
import kotlinx.coroutines.launch

class ApiViewModel(private val repo:PostsRepo, private val coroutines:CoroutinesManager): ViewModel() {


    private val _post = MutableLiveData<List<PostsModelRes>>()
    val post:LiveData<List<PostsModelRes>> get() = _post

    fun getPost() = coroutines.ioScope.launch {
       val response =  repo.getAllPost()

       if( response.isSuccessful){
           _post.postValue(response.body())
       }

    }

}