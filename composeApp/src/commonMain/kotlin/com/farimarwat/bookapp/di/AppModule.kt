package com.farimarwat.bookapp.di

import com.farimarwat.bookapp.data.remote.BookApi
import com.farimarwat.bookapp.data.repository.BookRepositoryImpl
import com.farimarwat.bookapp.domain.repository.BookRepository
import com.farimarwat.bookapp.domain.usecase.GetBooksUseCase
import com.farimarwat.bookapp.domain.usecase.SearchBookUseCase
import com.farimarwat.bookapp.presentation.BookViewModel
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val httpClient:HttpClient
expect val platformModule:Module

val sharedModule = module {
    singleOf(::BookApi)
    singleOf(::BookRepositoryImpl).bind<BookRepository>()
    viewModelOf(::BookViewModel)
    singleOf(::GetBooksUseCase)
    singleOf(::SearchBookUseCase)
}

