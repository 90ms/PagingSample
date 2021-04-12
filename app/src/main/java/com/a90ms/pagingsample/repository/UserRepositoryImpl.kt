package com.a90ms.pagingsample.repository

import com.a90ms.pagingsample.data.UserDao
import com.a90ms.pagingsample.network.UserService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userService: UserService
) : UserRepository {
    override fun fetchUserList() {
        TODO("Not yet implemented")
    }

    override fun fetchUserInfo() {
        TODO("Not yet implemented")
    }


}