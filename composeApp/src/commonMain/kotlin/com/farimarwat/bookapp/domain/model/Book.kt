package com.farimarwat.bookapp.domain.model

data class Book(
    val key: String,
    val title: String,
    val authors: List<String>,
    val coverId: Int?
) {
    fun getCoverImageUrl(): String? {
        return coverId?.let {
            "https://covers.openlibrary.org/b/id/$it-S.jpg"
        }
    }
}
