package com.farimarwat.bookapp.domain.model

data class BooksDto(
    val key: String,
    val name: String,
    val subject_type: String,
    val work_count: Int,
    val works: List<Work>
)