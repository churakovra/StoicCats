package com.churakov.stoiccats.api.stoic

import com.google.gson.annotations.SerializedName

data class StoicQuote(
    @SerializedName("author")
    private val author: String? = null,
    @SerializedName("quote")
    private val quote: String
)
