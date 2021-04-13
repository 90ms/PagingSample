package com.a90ms.pagingsample.model

/**
 * https://developers.kakao.com/docs/latest/ko/daum-search/dev-guide#search-image
 * */

data class ResponseImage(
    val meta: SearchMeta = SearchMeta(),
    val documents: List<SearchDocuments> = listOf()
)