package com.myapplication.bestwallpaper.data.api

import com.myapplication.bestwallpaper.data.api.model.PicsumItem
import com.myapplication.bestwallpaper.utils.Constants.END_POINT
import retrofit2.http.GET
import retrofit2.http.Query


interface PicSumApi {
    @GET(END_POINT)
    suspend fun getwallpaperimage(
        @Query("page") page: Int = 5,@Query("limit") limit: Int = 100
    ): List<PicsumItem>
}