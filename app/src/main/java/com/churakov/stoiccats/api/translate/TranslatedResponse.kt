package com.churakov.stoiccats.api.translate

import com.google.gson.annotations.SerializedName

data class TranslatedResponse(
    @SerializedName("translations")
    val translations: Array<TranslatedItem>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TranslatedResponse

        return translations.contentEquals(other.translations)
    }

    override fun hashCode(): Int {
        return translations.contentHashCode()
    }
}