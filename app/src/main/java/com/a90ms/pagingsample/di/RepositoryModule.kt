package com.a90ms.pagingsample.di

import com.a90ms.pagingsample.data.ImageDao
import com.a90ms.pagingsample.network.KakaoService
import com.a90ms.pagingsample.repository.ImageRepository
import com.a90ms.pagingsample.repository.ImageRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

    @Provides
    @ActivityRetainedScoped
    fun provideImageRepository(
        imageDao: ImageDao,
        kakaoService: KakaoService
    ): ImageRepository = ImageRepositoryImpl(imageDao, kakaoService)

}