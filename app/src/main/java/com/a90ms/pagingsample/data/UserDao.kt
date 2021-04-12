package com.a90ms.pagingsample.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.a90ms.pagingsample.model.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users LIMIT 4 OFFSET :offset")
    suspend fun getLimitUserList(offset: Int): List<User>

    @Query("SELECT * FROM users WHERE id=:id")
    suspend fun getInfo(id: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCharacter(character: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<User>)
}