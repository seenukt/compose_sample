package com.example.sidenavdrawer.apicall.modules

import com.example.sidenavdrawer.apicall.ApiViewModel
import org.koin.dsl.module

val viewModelModule = module {
   single {   ApiViewModel(get(),get())}
}