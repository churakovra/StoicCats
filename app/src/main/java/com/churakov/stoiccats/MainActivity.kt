package com.churakov.stoiccats

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.churakov.stoiccats.api.StoicApiFactory
import com.churakov.stoiccats.api.StoicApiService
import com.churakov.stoiccats.api.StoicQuote
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var stoicApi: StoicApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stoicApi = StoicApiFactory.getStoicApi
        lifecycleScope.launch {
            val stoicQuote = stoicApi.loadStoicQuote()
            Log.d("MainActivity", stoicQuote.toString())
        }
    }
}