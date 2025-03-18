package com.myapplication.bestwallpaper.data.api

import com.myapplication.bestwallpaper.data.api.model.PicsumItem
import com.myapplication.bestwallpaper.utils.Constants.BASE_URL
import com.myapplication.bestwallpaper.utils.Constants.END_POINT
import retrofit2.http.GET
import retrofit2.http.Query


interface PicSumApi {
    @GET(BASE_URL+END_POINT)
    fun getwallpaperimage(
        @Query("page") page: Int = 1,@Query("limit") limit: Int = 100
    ): List<PicsumItem>
}