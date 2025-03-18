package com.myapplication.bestwallpaper.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapplication.bestwallpaper.domain.repository.WallpaperRepository
import com.myapplication.bestwallpaper.presentation.WallpaperUiState
import com.myapplication.bestwallpaper.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WallpaperViewModel @Inject constructor(private val repository: WallpaperRepository): ViewModel() {

    private val _wallpaperList: MutableStateFlow<WallpaperUiState> =
        MutableStateFlow(WallpaperUiState.Loading)

    val wallpaperList get() = _wallpaperList.asStateFlow()

    fun fetchWallpeper(){
        viewModelScope.launch(Dispatchers.IO) {
           repository.getImages().collect(){ resource ->
               when (resource){
                   is Resource.Success ->{
                       if(resource.data.isNullOrEmpty()){
                           _wallpaperList.update { WallpaperUiState.Loading }
                       }else{
                           _wallpaperList.update { WallpaperUiState.Success(resource.data) }
                       }
                   }is Resource.Error ->{
                   _wallpaperList.update { WallpaperUiState.EmptyList }
                   }
               }
           }
        }
    }
}