package com.yakogdan.notey.app.app

import android.app.Application
import com.yakogdan.notey.app.di.appModule
import com.yakogdan.notey.app.di.dataModule
import com.yakogdan.notey.app.di.domainModule
import com.yakogdan.notey.data.database.room.AppRoomDatabase
//import com.yakogdan.notey.data.database.room.AppRoomDatabase
import com.yakogdan.notey.data.repository.NoteyRepositoryImpl
//import com.yakogdan.notey.domain.repository.NoteyRepository
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

//        startKoin {
//            androidLogger(Level.DEBUG)
//            androidContext(this@App)
//            modules(listOf(appModule, domainModule, dataModule))
//        }
//
        database = AppRoomDatabase.getInstance(context = applicationContext)

    }

    companion object {
        lateinit var database: AppRoomDatabase
//        fun getNoteRepository(): NoteyRepository = NoteyRepositoryImpl()
    }

}