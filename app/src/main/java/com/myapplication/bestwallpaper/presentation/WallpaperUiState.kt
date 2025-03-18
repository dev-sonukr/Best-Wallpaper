package com.myapplication.bestwallpaper.presentation

import com.myapplication.bestwallpaper.domain.entities.WallpaperLink

sealed class WallpaperUiState{
    object Loading : WallpaperUiState()
    object EmptyList : WallpaperUiState()
    data class Success(val data: List<WallpaperLink>) : WallpaperUiState()
    data class Error(val message:String) : WallpaperUiState()
}