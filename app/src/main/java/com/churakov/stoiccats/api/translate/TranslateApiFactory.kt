package com.churakov.stoiccats.api.translate

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object TranslateApiFactory {

    private const val BASE_URL = "https://translate.api.cloud.yandex.net/translate/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val _translateInstance: TranslateApiService? = null
    val translateInstance: TranslateApiService =
        _translateInstance ?: retrofit.create(TranslateApiService::class.java)
}