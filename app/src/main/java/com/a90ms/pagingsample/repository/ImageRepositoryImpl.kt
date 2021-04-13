package com.a90ms.pagingsample.repository

import com.a90ms.pagingsample.data.ImageDao
import com.a90ms.pagingsample.model.Images
import com.a90ms.pagingsample.network.KakaoService
import timber.log.Timber
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageDao: ImageDao,
    private val kakaoService: KakaoService
) : ImageRepository {

    override suspend fun fetchImageList(nextPage: Int, query: String): MutableList<Images> {
//        val localImageList = imageDao.getImageList(nextPage)
//        if (localImageList.isEmpty()) {
//            imageDao.insertAll(kakaoService.getImageList())
//        }
        try {
            val getImageList = kakaoService.getImageList(query = query)
            imageDao.insertAll(getImageList)
            Timber.w("success :: $getImageList")
        } catch (e : Exception) {
            Timber.e("failed :: $e")
        }

        return imageDao.getImageList(nextPage)
    }
}