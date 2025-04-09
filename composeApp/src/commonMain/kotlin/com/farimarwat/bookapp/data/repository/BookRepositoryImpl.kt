package com.farimarwat.bookapp.data.repository

import com.farimarwat.bookapp.data.remote.BookApi
import com.farimarwat.bookapp.domain.model.Book
import com.farimarwat.bookapp.domain.repository.BookRepository

class BookRepositoryImpl(private val api:BookApi): BookRepository {
    override suspend fun getBooks(limit: Int): List<Book> {
        return api.getBooks(limit)
    }

    override suspend fun searchBook(query: String, limit: Int): List<Book> {
        return api.searchBook(query,limit)
    }
}