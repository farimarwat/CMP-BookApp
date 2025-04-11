package com.farimarwat.bookapp.domain.usecase

import com.farimarwat.bookapp.domain.repository.BookRepository

class GetDetailsUseCase(private val repository: BookRepository) {
    operator suspend fun invoke(key:String):String{
        return repository.getDetails(key)
    }
}