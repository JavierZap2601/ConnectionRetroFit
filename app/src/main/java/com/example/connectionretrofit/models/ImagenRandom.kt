package com.example.connectionretrofit.models

import com.google.gson.annotations.SerializedName

data class ImagenRandom(
    @SerializedName("message") val message: String,
    var status: String
)
