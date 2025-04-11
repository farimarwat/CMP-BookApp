package com.farimarwat.bookapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Work(
    val authors: List<Author>,
    val cover_id: Int,
    val key: String,
    val public_scan: Boolean,
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