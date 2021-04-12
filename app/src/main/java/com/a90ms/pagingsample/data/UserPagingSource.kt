package com.a90ms.pagingsample.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.a90ms.pagingsample.model.User
import com.a90ms.pagingsample.repository.UserRepository
import java.net.UnknownHostException

class UserPagingSource(
    private val userRepository: UserRepository
) : PagingSource<Int, User>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val nextPageNumber  = params.key ?: 0
            val characterPage = userRepository.fetchUserList(nextPageNumber)
            LoadResult.Page(
                data = characterPage,
                prevKey = null,
                nextKey = nextPageNumber + 4
            )
        } catch (e: UnknownHostException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return null
    }
}