package com.farimarwat.bookapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.jetbrains.compose.ui.tooling.preview.Preview

import com.farimarwat.bookapp.presentation.viewmodel.BookViewModel
import com.farimarwat.bookapp.presentation.components.SearchBar
import com.farimarwat.bookapp.presentation.screen.HomeScreen
import com.farimarwat.bookapp.presentation.ui.getColorScheme
import kotlinx.coroutines.launch

import org.koin.compose.koinInject

@Composable
@Preview
fun App(viewModel: BookViewModel = koinInject<BookViewModel>()) {
    MaterialTheme(
        colorScheme = getColorScheme()
    ) {
        var showContent by remember { mutableStateOf(false) }
        val scope = rememberCoroutineScope()
        val books by viewModel.books.collectAsStateWithLifecycle()
        LaunchedEffect(Unit){
            viewModel.getBooks()
        }
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchBar(
                onSearch = {

                },
                onFilter = {
                    scope.launch {
                        viewModel.filter(it)
                    }
                }
            )
            HomeScreen(books)
        }
    }
}