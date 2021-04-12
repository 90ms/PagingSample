package com.a90ms.pagingsample.di

import android.app.Application
import androidx.room.Room
import com.a90ms.pagingsample.data.AppDatabase
import com.a90ms.pagingsample.data.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object LocalDatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(application: Application): AppDatabase =
        Room.databaseBuilder(application, AppDatabase::class.java, "users-db")
            .build()

    @Provides
    fun provideUserDao(appDatabase: AppDatabase) : UserDao =
        appDatabase.userDao()
}