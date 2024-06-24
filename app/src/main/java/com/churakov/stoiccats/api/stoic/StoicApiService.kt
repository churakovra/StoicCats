package com.churakov.stoiccats.api.stoic

import retrofit2.http.GET

interface StoicApiService {
    @GET("stoic-quote")
    suspend fun loadStoicQuote(): StoicQuote
}