package com.churakov.stoiccats.api

import retrofit2.Call
import retrofit2.http.GET

interface StoicApiService {
    @GET("stoic-quote")
    suspend fun loadStoicQuote(): StoicQuote
}