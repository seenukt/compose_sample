package com.example.sidenavdrawer.apicall.modules

import com.example.sidenavdrawer.apicall.apiinterface.ApiInterface
import com.example.sidenavdrawer.corutiens.CoroutinesManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val netWorkModule = module {

    single { OkHttpClient.Builder().addInterceptor(get<HttpLoggingInterceptor>()).build() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ApiInterface> { get<Retrofit>().create(ApiInterface::class.java) }

    single {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }
    single { CoroutinesManager() }
}