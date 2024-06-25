package com.churakov.stoiccats.api.cats

data class CatsApiQueryNoRetrofit(
    val font: String = "Impact",
    val fontSize: Int = 30,
    val fontColor: String = "#FFF",
    val fontBackground: String = "none",
    val position: String = "center",
    val width: Int = 400,
    val height: Int = 500
) {
    fun getQuery(): Map<String, Any> {
        return mapOf(
            "font" to font,
            "fontSize" to fontSize,
            "fontColor" to fontColor,
            "fontBackground" to fontBackground,
            "position" to position,
//            "width" to width,
//            "height" to height
        )
    }
}
