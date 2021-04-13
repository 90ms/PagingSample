package com.a90ms.pagingsample.repository

import com.a90ms.pagingsample.model.SearchDocuments
interface ImageRepository {

    suspend fun fetchImageList(nextPage: Int, query: String): MutableList<SearchDocuments>

}