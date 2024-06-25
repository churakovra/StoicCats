package com.churakov.stoiccats

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.churakov.stoiccats.api.cats.CatsApiNoRetrofit
import com.churakov.stoiccats.api.cats.CatsApiQueryNoRetrofit
import com.churakov.stoiccats.api.stoic.StoicApiFactory
import com.churakov.stoiccats.api.translate.TranslateApiFactory
import java.net.URI

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _imgUrlData = MutableLiveData<URI>()
    val imgUrlData: LiveData<URI> = _imgUrlData

    suspend fun loadImg() {
        val nextQuote = getQuote()
        val translatedRandomQuote = translateQuote(nextQuote)
        val catImgUrlString = getCatImgUrlString(translatedRandomQuote)
        _imgUrlData.value = URI(catImgUrlString)
    }

    private suspend fun getQuote(): String {
        val quoteApi = StoicApiFactory.getStoicApi
        val quote = quoteApi.loadStoicQuote().quote
        return quote
    }

    private suspend fun translateQuote(quote: String): String {
        val translateApi = TranslateApiFactory.translateInstance
        val translateQuoteQuery = arrayOf(quote)
        val translatedQuote = translateApi.translateText("ru", translateQuoteQuery)
        return translatedQuote.translations[0].text
    }

    private fun getCatImgUrlString(path: String): String {
        val catsQuery = CatsApiQueryNoRetrofit().getQuery()
        val catsUrl = CatsApiNoRetrofit.constructUrl(path, catsQuery)
        return catsUrl
    }
}