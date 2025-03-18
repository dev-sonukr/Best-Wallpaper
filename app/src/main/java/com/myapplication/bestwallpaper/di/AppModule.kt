package com.myapplication.bestwallpaper.di

import com.myapplication.bestwallpaper.data.api.PicSumApi
import com.myapplication.bestwallpaper.data.api.WallpaperRepoImpl
import com.myapplication.bestwallpaper.domain.repository.WallpaperRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule{

    companion object AppModule {
        @Provides
        @Singleton

        fun provideRetrofitApi(): PicSumApi {
            return Retrofit.Builder()
                .build()
                .create(PicSumApi::class.java)
        }
    }

    @Binds
    fun provideWallpaperRepository(repository: WallpaperRepoImpl) :WallpaperRepository
}