package com.myapplication.bestwallpaper.domain.repository

import com.myapplication.bestwallpaper.domain.entities.WallpaperLink
import com.myapplication.bestwallpaper.utils.Resource
import kotlinx.coroutines.flow.Flow

interface WallpaperRepository {
     fun getImages() : Flow<Resource<List<WallpaperLink>>>
}