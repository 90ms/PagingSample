package com.a90ms.pagingsample.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.a90ms.pagingsample.model.SearchDocuments
import com.a90ms.pagingsample.repository.ImageRepository
import com.a90ms.pagingsample.util.SEARCH_QUERY
import java.net.UnknownHostException

class SearchImagePagingSource(
    private val imageRepository: ImageRepository
) : PagingSource<Int, SearchDocuments>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, SearchDocuments> {
        return try {

            val nextPageNumber = params.key ?: 0
            val getImageData = imageRepository.fetchImageList(nextPageNumber, SEARCH_QUERY)
            LoadResult.Page(
                data = getImageData,
                prevKey = null,
                nextKey = nextPageNumber + 1
            )

        } catch (e: UnknownHostException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, SearchDocuments>): Int? {
        return null
    }
}