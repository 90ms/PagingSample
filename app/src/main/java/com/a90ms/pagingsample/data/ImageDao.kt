package com.a90ms.pagingsample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.a90ms.pagingsample.model.Images

@Dao
interface ImageDao {
    @Query("SELECT * FROM images LIMIT 10 OFFSET :offset")
    suspend fun getImageList(offset: Int): MutableList<Images>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(images: Images)
}