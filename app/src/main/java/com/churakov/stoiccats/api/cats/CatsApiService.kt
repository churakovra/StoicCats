package com.churakov.stoiccats.api.cats

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.net.URL

interface CatsApiService {

    @GET("cat/says/{text}")
    suspend fun getCatImg(
        @Path("text") text: String,
        @Query("font") font: String = "Impact",
        @Query("fontSize") fontSize: Int = 50,
        @Query("fontColor") fontColor: String = "#FFF",
        @Query("fontBackground") fontBackground: String = "none",
        @Query("position") position: String = "center",
        @Query("width") width: Int = 500,
        @Query("height") height: Int = 500
    ): String
}