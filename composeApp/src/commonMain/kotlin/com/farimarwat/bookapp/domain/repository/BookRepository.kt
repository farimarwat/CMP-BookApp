package com.farimarwat.bookapp.domain.repository

import com.farimarwat.bookapp.data.remote.BookApi
import com.farimarwat.bookapp.domain.model.Book

interface BookRepository {
    suspend fun getBooks(limit:Int):List<Book>
    suspend fun searchBook(query:String,limit:Int):List<Book>
    suspend fun getDetails(key:String):String
}