package com.example.sidenavdrawer

import android.app.Application
import com.example.sidenavdrawer.apicall.modules.netWorkModule
import com.example.sidenavdrawer.apicall.modules.persistenceModule
import com.example.sidenavdrawer.apicall.modules.viewModelModule
import org.koin.core.context.startKoin

class Applications : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            applicationContext
            modules(
                listOf(
                    netWorkModule,
                    viewModelModule,
                    persistenceModule
                )
            )
        }
    }
}