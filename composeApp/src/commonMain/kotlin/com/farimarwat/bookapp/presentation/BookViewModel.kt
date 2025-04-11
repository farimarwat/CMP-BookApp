package com.farimarwat.bookapp.presentation

import androidx.lifecycle.ViewModel
import com.farimarwat.bookapp.domain.model.Book
import com.farimarwat.bookapp.domain.usecase.GetBooksUseCase
import com.farimarwat.bookapp.domain.usecase.SearchBookUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class BookViewModel(
    private val getBooksUseCase: GetBooksUseCase,
    private val searchBookUseCase: SearchBookUseCase
):ViewModel() {
    private var _books:MutableStateFlow<List<Book>> = MutableStateFlow(emptyList())
    val books = _books.asStateFlow()

    private var _search:MutableStateFlow<List<Book>> = MutableStateFlow(emptyList())
    val search = _search.asStateFlow()
    suspend fun getBooks(){
        _books.value = getBooksUseCase()
        _books.value.forEach { item ->
            println(item.title)
        }
    }

    suspend fun searchBook(query:String){
        _search.value = searchBookUseCase(query)
    }
}