package com.yakogdan.notey.app.app

import android.app.Application
import com.yakogdan.notey.data.database.room.AppRoomDatabase
//import com.yakogdan.notey.data.database.room.AppRoomDatabase
//import com.yakogdan.notey.domain.repository.NoteyRepository

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