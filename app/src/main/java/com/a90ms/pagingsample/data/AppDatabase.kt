package com.a90ms.pagingsample.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.a90ms.pagingsample.model.SearchDocuments
import com.a90ms.pagingsample.util.DatabaseConverters

@Database(entities = [SearchDocuments::class], version = 2, exportSchema = false)
@TypeConverters(DatabaseConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun imageDao(): ImageDao
}
