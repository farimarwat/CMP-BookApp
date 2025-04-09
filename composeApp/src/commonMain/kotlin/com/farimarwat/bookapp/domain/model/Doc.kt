package com.farimarwat.bookapp.domain.model

data class Doc(
    val author_key: List<String>,
    val author_name: List<String>,
    val cover_edition_key: String,
    val cover_i: Int,
    val edition_count: Int,
    val first_publish_year: Int,
    val has_fulltext: Boolean,
    val ia: List<String>,
    val ia_collection_s: String,
    val key: String,
    val language: List<String>,
    val lending_edition_s: String,
    val lending_identifier_s: String,
    val public_scan_b: Boolean,
    val title: String
){
    fun toBook():Book{
        return Book(
            key = this.key,
            title = this.title,
            authors = this.author_name,
            coverId = this.cover_i
        )
    }
}