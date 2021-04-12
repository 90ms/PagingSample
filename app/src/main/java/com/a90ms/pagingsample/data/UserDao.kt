package com.a90ms.pagingsample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.a90ms.pagingsample.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users LIMIT 4 OFFSET :offset")
    suspend fun getLimitUserList(offset: Int): MutableList<User>

    @Query("SELECT * FROM users WHERE id=:id")
    suspend fun getInfo(id: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserInfo(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: MutableList<User>)
}