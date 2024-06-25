package com.churakov.stoiccats

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Layout
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.churakov.stoiccats.api.cats.CatsApiNoRetrofit
import com.churakov.stoiccats.api.cats.CatsApiQueryNoRetrofit
import com.churakov.stoiccats.api.stoic.StoicApiFactory
import com.churakov.stoiccats.api.translate.TranslateApiFactory
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgView = findViewById<ImageView>(R.id.catImageView)
        val nextImgBtn = findViewById<Button>(R.id.next_img_bt)

        lifecycleScope.launch {
            setLoadedImg(imgView)
        }

        nextImgBtn.setOnClickListener {
            lifecycleScope.launch {
                setLoadedImg(imgView)
            }
        }
    }

    private suspend fun loadImg(): URL {
        val quoteApi = StoicApiFactory.getStoicApi
        val quote = quoteApi.loadStoicQuote().quote

        val translateApi = TranslateApiFactory.translateInstance
        val translateQuoteQuery = arrayOf(quote)
        val translatedQuote = translateApi.translateText("ru", translateQuoteQuery)

        val catsQuotePath: String = translatedQuote.translations[0].text
        val catsQuery = CatsApiQueryNoRetrofit().getQuery()
        val catsUrl = CatsApiNoRetrofit.constructUrl(catsQuotePath, catsQuery)
        Log.d("MainActivity", catsUrl.toString())

        return catsUrl
    }

    private suspend fun setLoadedImg(imgView: ImageView) {
        try {
            val catsUrl = loadImg()
            Glide.with(this@MainActivity)
                .load(catsUrl)
                .into(imgView)
        } catch (e: Exception) {
            Log.d("MainActivity", e.toString())
        }
    }
}