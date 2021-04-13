package com.a90ms.pagingsample.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-image
 * */
@Entity(tableName = "images")
data class Images(
    @PrimaryKey
    @SerializedName("meta") val meta: MetaData = MetaData(),
    @SerializedName("documents") val documents: List<Documents> = listOf()
)

data class MetaData(
    val total_count: Int = 0,
    val pageable_count: Int = 0,
    val is_end: Boolean = false
)

data class Documents(
    val collection: String = "",
    val thumbnail_url: String = "",
    val image_url: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val display_sitename: String = "",
    val doc_url: String = "",
    val datetime: Date = Date()
)