package com.myapplication.bestwallpaper.data.api

import com.myapplication.bestwallpaper.domain.entities.WallpaperLink
import com.myapplication.bestwallpaper.domain.repository.WallpaperRepository
import com.myapplication.bestwallpaper.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class WallpaperRepoImpl @Inject constructor(private val picSumApi: PicSumApi): WallpaperRepository {

    override fun getImages(): Flow<Resource<List<WallpaperLink>>> = flow{
//        retrofit call
        try {
            val response = picSumApi.getwallpaperimage()

            response?.let {
                val wallpaperLinks : List<WallpaperLink> = response.map {
                    WallpaperLink(it.downloadUrl)
                }
                emit(Resource.Success(wallpaperLinks))
            }
        }catch (e: Exception){
            var errorOutput = ""
            if(e.message != null){
                errorOutput =e.message!!
            }else{
               errorOutput = "Something went wrong"
            }
            emit(Resource.Error(null,errorOutput))
        }
    }
}

