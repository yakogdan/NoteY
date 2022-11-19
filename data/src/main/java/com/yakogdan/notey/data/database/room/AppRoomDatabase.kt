package com.yakogdan.notey.data.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yakogdan.notey.data.database.room.dao.NoteRoomDao
import com.yakogdan.notey.data.database.room.entities.NoteDbEntity

@Database(entities = [NoteDbEntity::class], version = 2)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteRoomDao

    companion object {
        fun create(context: Context): AppRoomDatabase =
            Room.databaseBuilder(
                context,
                AppRoomDatabase::class.java,
                "notes_database"
            ).build()
    }
}