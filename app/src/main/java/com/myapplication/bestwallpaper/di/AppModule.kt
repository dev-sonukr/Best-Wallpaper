package com.myapplication.bestwallpaper.di

import com.myapplication.bestwallpaper.data.api.PicSumApi
import com.myapplication.bestwallpaper.data.api.WallpaperRepoImpl
import com.myapplication.bestwallpaper.domain.repository.WallpaperRepository
import com.myapplication.bestwallpaper.utils.Constants.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule{

    companion object{
        @Provides
        @Singleton

        fun provideRetrofitApi(): PicSumApi {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PicSumApi::class.java)
        }
    }

    @Binds
    @Singleton
    fun provideWallpaperRepository(repository: WallpaperRepoImpl) :WallpaperRepository
}