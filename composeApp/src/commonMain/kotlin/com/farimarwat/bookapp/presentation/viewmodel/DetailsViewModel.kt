package com.farimarwat.bookapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farimarwat.bookapp.domain.model.Book
import com.farimarwat.bookapp.domain.usecase.GetDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getDetailsUseCase: GetDetailsUseCase
):ViewModel() {
    private var _currentBook:MutableStateFlow<Book?> = MutableStateFlow(null)
    val currentBook = _currentBook.asStateFlow()

    fun setCurrentBook(book:Book){
        _currentBook.value = book
        if(book.description.isEmpty()){
            getDetails()
        }
    }
    fun getDetails()= viewModelScope.launch(Dispatchers.IO){
        _currentBook.value?.let{
            val details = getDetailsUseCase(it.key)
            _currentBook.value = it.copy(
                description = details
            )
        }
    }
}