package com.a90ms.pagingsample.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.a90ms.pagingsample.model.Images
import com.a90ms.pagingsample.repository.ImageRepository
import com.a90ms.pagingsample.util.SEARCH_QUERY
import java.net.UnknownHostException

class SearchImagePagingSource(
    private val imageRepository: ImageRepository
) : PagingSource<Int, Images>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Images> {
        return try {
            val nextPageNumber  = params.key ?: 0
            val characterPage = imageRepository.fetchImageList(nextPageNumber,SEARCH_QUERY)
            LoadResult.Page(
                data = characterPage,
                prevKey = null,
                nextKey = nextPageNumber + 4
            )
        } catch (e: UnknownHostException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Images>): Int? {
        return null
    }
}