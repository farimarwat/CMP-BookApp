package com.farimarwat.bookapp.domain.model

import kotlin.math.roundToInt

data class Book(
    val key: String,
    val title: String,
    val authors: List<String>,
    val coverId: Int?,
    var ratingAverage:Double = 0.0,
    var ratingCount:Int = 0,
    val description:String = "",
    val languages:List<String> = emptyList(),
) {
    fun getCoverImageUrl(): String? {
        return coverId?.let {
            "https://covers.openlibrary.org/b/id/$it-S.jpg"
        }
    }
    fun getFormattedRating():String{
        return "${(ratingAverage * 100).roundToInt() / 100.0}"
    }
}
