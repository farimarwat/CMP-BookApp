package com.farimarwat.bookapp.domain.usecase

import com.farimarwat.bookapp.domain.model.Book
import com.farimarwat.bookapp.domain.repository.BookRepository

class SearchBookUseCase(private val repo:BookRepository) {
    operator suspend fun invoke(query:String,limit:Int = 10):List<Book>{
        return repo.searchBook(query,limit)
    }
}