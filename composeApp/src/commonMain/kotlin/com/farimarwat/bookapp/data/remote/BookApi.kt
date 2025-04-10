package com.farimarwat.bookapp.data.remote

import com.farimarwat.bookapp.domain.model.Book
import com.farimarwat.bookapp.domain.model.BooksDto
import com.farimarwat.bookapp.domain.model.DetailsDto
import com.farimarwat.bookapp.domain.model.RatingDto
import com.farimarwat.bookapp.domain.model.SearchDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.parameters
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive

class BookApi(private val client:HttpClient){

    suspend fun getBooks(limit:Int):List<Book>{
        val result = client.get {
            url("https://openlibrary.org/subjects/fantasy.json")
            parameters {
                append("limit","$limit")
            }
        }.body<BooksDto>()
        return result.works.map {
            val book = it.toBook()
            val rating = getRating(it.key)
            book.ratingCount = rating.summary.count
            book.ratingAverage = rating.summary.average
            book
        }
    }

    suspend fun searchBook(query:String,limit:Int):List<Book>{
        return client.get {
            url("https://openlibrary.org/search.json")
            parameters {
                append("q",query)
                append("limit","$limit")
            }
        }.body<SearchDto>()
            .docs.map { it.toBook() }
    }

    suspend fun getRating(key:String):RatingDto{
        return client.get {
            url("https://openlibrary.org$key/ratings.json")
        }
            .body<RatingDto>()
    }
    suspend fun getDetails(key: String): String {
        val response: String = client.get {
            url("https://openlibrary.org$key.json")
        }.body()

        val json = Json.parseToJsonElement(response).jsonObject

        val descriptionElement = json["description"]
        return when (descriptionElement) {
            is JsonPrimitive -> descriptionElement.content
            is JsonObject -> descriptionElement["value"]?.jsonPrimitive?.content ?: ""
            else -> ""
        }
    }

}