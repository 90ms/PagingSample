package com.a90ms.pagingsample.repository

import com.a90ms.pagingsample.model.User

interface UserRepository {

    suspend fun fetchUserList(nextPage: Int): MutableList<User>
    suspend fun fetchUserInfo(userId: Int): User
}