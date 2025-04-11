package com.farimarwat.bookapp.di

import com.farimarwat.bookapp.data.remote.BookApi
import com.farimarwat.bookapp.data.repository.BookRepositoryImpl
import com.farimarwat.bookapp.domain.repository.BookRepository
import com.farimarwat.bookapp.domain.usecase.GetBooksUseCase
import com.farimarwat.bookapp.domain.usecase.GetDetailsUseCase
import com.farimarwat.bookapp.domain.usecase.SearchBookUseCase
import com.farimarwat.bookapp.presentation.viewmodel.DetailsViewModel
import com.farimarwat.bookapp.presentation.viewmodel.HomeViewModel
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
    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailsViewModel)
    singleOf(::GetBooksUseCase)
    singleOf(::SearchBookUseCase)
    singleOf(::GetDetailsUseCase)
}

