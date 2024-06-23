package com.churakov.stoiccats.api

import com.google.gson.annotations.SerializedName

data class StoicQuote(
    @SerializedName("author")
    private val author: String? = null,
    @SerializedName("quote")
    private val quote: String
)
