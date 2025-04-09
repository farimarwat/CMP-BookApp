package com.farimarwat.bookapp.domain.usecase

import com.farimarwat.bookapp.domain.model.Book
import com.farimarwat.bookapp.domain.repository.BookRepository

class GetBooksUseCase(private val repo:BookRepository) {
    operator suspend fun invoke(limit:Int = 10):List<Book>{
        return repo.getBooks(limit)
    }
}