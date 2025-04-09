package com.farimarwat.bookapp.data.remote

import com.farimarwat.bookapp.domain.model.Book
import com.farimarwat.bookapp.domain.model.BooksDto
import com.farimarwat.bookapp.domain.model.SearchDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.parameters

class BookApi(private val client:HttpClient){

    suspend fun getBooks(limit:Int = 10):List<Book>{
        val result = client.get {
            url("https://openlibrary.org/subjects/fantasy.json")
            parameters {
                append("limit","$limit")
            }
        }.body<BooksDto>()
        return result.works.map { it.toBook() }
    }

    suspend fun searchBook(query:String,limit:Int = 10):List<Book>{
        return client.get {
            url("https://openlibrary.org/search.json")
            parameters {
                append("q",query)
                append("limit","$limit")
            }
        }.body<SearchDto>()
            .docs.map { it.toBook() }
    }
}