package com.myapplication.bestwallpaper.data.api.model

import com.google.gson.annotations.SerializedName

data class PicsumItem(
    val author: String,
    @SerializedName("download_url")
    val downloadUrl: String,
    val width: Int,
    val height: Int,
    val id: String,
    val url: String,
)
