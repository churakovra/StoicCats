package com.churakov.stoiccats.api

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object StoicApiFactory {
    private const val BASE_URL = "https://stoic.tekloon.net/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val _getStoicApi: StoicApiService = retrofit.create(StoicApiService::class.java)
    val getStoicApi: StoicApiService = _getStoicApi
}