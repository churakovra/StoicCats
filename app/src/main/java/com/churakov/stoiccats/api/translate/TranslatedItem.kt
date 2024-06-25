package com.churakov.stoiccats.api.translate

import com.google.gson.annotations.SerializedName

data class TranslatedItem(
    @SerializedName("text")
    val text: String
)
