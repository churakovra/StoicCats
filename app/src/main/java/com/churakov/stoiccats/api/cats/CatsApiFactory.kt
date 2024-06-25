package com.churakov.stoiccats.api.cats

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CatsApiFactory {

    private const val BASE_URL = "https://cataas.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val _catsApiInstance: CatsApiService? = null
    val catsApiInstance: CatsApiService =
        _catsApiInstance ?: retrofit.create(CatsApiService::class.java)
}