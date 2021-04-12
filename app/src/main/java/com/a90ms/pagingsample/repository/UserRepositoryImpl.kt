package com.a90ms.pagingsample.repository

import com.a90ms.pagingsample.data.UserDao
import com.a90ms.pagingsample.model.User
import com.a90ms.pagingsample.network.UserService
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userService: UserService
) : UserRepository {

    override suspend fun fetchUserList(nextPage: Int): MutableList<User> {
        val localUserList = userDao.getLimitUserList(nextPage)
        if (localUserList.isEmpty()) {
            userDao.insertAll(userService.getUserList())
        }
        return userDao.getLimitUserList(nextPage)
    }

    override suspend fun fetchUserInfo(userId: Int): User {
        val userInfo: User
        val localUserInfo = userDao.getInfo(userId)
        if (localUserInfo != null) {
            userInfo = localUserInfo
        } else {
            userInfo = userService.getUserInfo(userId)
            userDao.insertUserInfo(userInfo)
        }
        return userInfo
    }

}