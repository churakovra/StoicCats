package com.churakov.stoiccats.api.translate

import com.churakov.stoiccats.Config
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface TranslateApiService {
    @Headers(
        "Content-type: application/json",
        "Authorization: Api-Key ${Config.API_TOKEN}"
    )
    @POST("v2/translate")
    suspend fun translateText(
        @Query("sourceLanguageCode") sourceLanguageCode: String,
        @Query("targetLanguageCode") targetLanguageCode: String,
        @Query("texts") text: Array<String>
    ): TranslatedResponse
}