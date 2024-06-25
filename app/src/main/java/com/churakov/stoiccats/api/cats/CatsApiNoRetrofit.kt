package com.churakov.stoiccats.api.cats

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

//only for CatsApi
object CatsApiNoRetrofit {

    private var _instance: CatsApiNoRetrofit? = null
    val instance: CatsApiNoRetrofit = _instance ?: CatsApiNoRetrofit


    fun loadDogImage(path: String, query: Map<String, String>) {
        val url = constructUrl(path, query)
        val urlConnection: HttpURLConnection
        try {
            urlConnection = url.openConnection() as HttpURLConnection
            val inputStream = urlConnection.inputStream
            val inputStreamReader = InputStreamReader(inputStream)
            val bufferedReader = BufferedReader(inputStreamReader)

            val data = StringBuilder()
            do {
                val result = bufferedReader.readLine()

                if (result != null) {
                    data.append(result)
                }
            } while (result != null)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun <T> constructUrl(inputPath: String, inputQuery: Map<String, T>): URL {
        val path = pathConstructor(inputPath)
        val query = queryConstructor(inputQuery)
        val baseUrl = "https://cataas.com/cat/says/$path?$query"
        val url = URL(baseUrl)
        return url
    }

    private fun pathConstructor(path: String): String = path.trim().replace(" ", "%20")

    private fun <T> queryConstructor(query: Map<String, T>): String {
        val result = StringBuilder()
        for ((index, elem) in query.keys.withIndex()) {
            result.append("${elem}=${validateQuery(query[elem].toString())}")
            if (index < query.size - 1) {
                result.append("&")
            }
        }
        return result.toString()
    }

    private fun validateQuery(query: String): String {
        return if (query.startsWith("#")) {
            query.replace("#", "%23")
        } else {
            query
        }
    }
}