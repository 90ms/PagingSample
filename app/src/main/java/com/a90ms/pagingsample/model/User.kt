package com.a90ms.pagingsample.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User {

    @PrimaryKey
    val id: Int=1
}