package com.example.sidenavdrawer.apicall.modules

import com.example.sidenavdrawer.apicall.repo.PostsRepo
import org.koin.core.module.Module
import org.koin.dsl.module

val persistenceModule =  module {

    single { PostsRepo(get()) }

}