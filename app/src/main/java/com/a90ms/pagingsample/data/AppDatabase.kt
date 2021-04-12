package com.a90ms.pagingsample.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.a90ms.pagingsample.model.User
import com.a90ms.pagingsample.util.StringListConverters

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(StringListConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
