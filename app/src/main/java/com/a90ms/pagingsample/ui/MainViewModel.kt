package com.a90ms.pagingsample.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a90ms.pagingsample.repository.ImageRepository
import com.a90ms.pagingsample.util.SEARCH_QUERY
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
    private val repository: ImageRepository
) : ViewModel () {


    fun fetchSearchImage(query: String) {
        viewModelScope.launch {
            repository.fetchImageList(1,SEARCH_QUERY)
        }
    }

}