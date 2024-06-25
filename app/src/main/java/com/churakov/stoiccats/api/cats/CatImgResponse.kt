package com.churakov.stoiccats.api.cats

import com.google.gson.annotations.SerializedName

data class CatImgResponse(
    @SerializedName("src")
    val imgResponse: String
)
