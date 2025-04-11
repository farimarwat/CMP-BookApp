package com.farimarwat.bookapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Work(
    val authors: List<Author>,
    val cover_edition_key: String,
    val cover_id: Int,
    val edition_count: Int,
    val first_publish_year: Int,
    val has_fulltext: Boolean,
    val ia: String,
    val ia_collection: List<String>,
    val key: String,
    val lending_edition: String,
    val lending_identifier: String,
    val printdisabled: Boolean,
    val public_scan: Boolean,
    val subject: List<String>,
    val title: String,
    val description: Description? = null
){
    fun toBook():Book{
        return Book(
            key = this.key,
            title = this.title,
            authors = this.authors.map { it.name },
            coverId = this.cover_id,
            description = this.description?.value ?: ""
        )
    }
}