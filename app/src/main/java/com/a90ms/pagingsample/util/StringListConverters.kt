package com.a90ms.pagingsample.util

import androidx.room.TypeConverter
import com.a90ms.pagingsample.model.Documents
import com.a90ms.pagingsample.model.MetaData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

object StringListConverters {

    /**
     * Cannot figure out how to save this field into database. You can consider adding a type converter for it.
     * */

    @TypeConverter
    @JvmStatic
    fun fromDocuments(json: String): List<Documents> {
        return Gson().fromJson(json, object : TypeToken<List<Documents>>() {}.type)
    }

    @TypeConverter
    @JvmStatic
    fun fromMetadatas(json: String): MetaData {
        return Gson().fromJson(json, object : TypeToken<List<MetaData>>() {}.type)
    }

    @TypeConverter
    @JvmStatic
    fun fromDocumentsList(list: List<Documents>) = Gson().toJson(list)

    @TypeConverter
    @JvmStatic
    fun fromMeataData(metaData: MetaData) = Gson().toJson(metaData)

}