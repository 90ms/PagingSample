package com.a90ms.pagingsample.di

import com.a90ms.pagingsample.data.UserDao
import com.a90ms.pagingsample.network.UserService
import com.a90ms.pagingsample.repository.UserRepository
import com.a90ms.pagingsample.repository.UserRepositoryImpl
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    fun provideUserRepository(
        userDao: UserDao,
        userService: UserService
    ): UserRepository = UserRepositoryImpl(userDao, userService)

}