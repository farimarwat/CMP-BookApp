package com.farimarwat.bookapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farimarwat.bookapp.domain.model.Book
import com.farimarwat.bookapp.domain.usecase.GetBooksUseCase
import com.farimarwat.bookapp.domain.usecase.SearchBookUseCase
import com.farimarwat.bookapp.presentation.state.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getBooksUseCase: GetBooksUseCase,
    private val searchBookUseCase: SearchBookUseCase
):ViewModel() {
    private var _books:MutableStateFlow<List<Book>> = MutableStateFlow(emptyList())
    val books = _books.asStateFlow()
    private var originalList = emptyList<Book>()

    private var _search:MutableStateFlow<List<Book>> = MutableStateFlow(emptyList())
    val search = _search.asStateFlow()

    private var _uiState = MutableStateFlow<UiState<List<Book>>>(UiState.Empty)
    val uiState = _uiState.asStateFlow()
    suspend fun getBooks(){
        _uiState.value = UiState.Loading
        originalList = getBooksUseCase()
        _books.value = originalList.toList()
        _uiState.value = UiState.Success(_books.value)
    }

    suspend fun searchBook(query:String){
        _search.value = searchBookUseCase(query)
    }
    fun filter(text:String) = viewModelScope.launch(Dispatchers.IO){
        print("Text: ${text}")
        if(text.isNotBlank()){
           _books.value = originalList.toList().filter {
               it.title.lowercase().contains(text)
           }
        } else {
            _books.value = originalList
        }
    }
}