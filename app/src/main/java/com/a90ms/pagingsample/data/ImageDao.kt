package com.a90ms.pagingsample.data

import androidx.room.*
import com.a90ms.pagingsample.model.SearchDocuments

@Dao
interface ImageDao {
    @Query("SELECT * FROM images LIMIT 10 OFFSET :offset")
    suspend fun getImageList(offset: Int): MutableList<SearchDocuments>

//    @Query("SELECT * FROM images ORDER BY meta DESC LIMIT 1")
//    suspend fun getLastItem(): MetaData

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(images: SearchDocuments)

}