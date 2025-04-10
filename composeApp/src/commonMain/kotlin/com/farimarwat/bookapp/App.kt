package com.farimarwat.bookapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import bookapp.composeapp.generated.resources.Res
import bookapp.composeapp.generated.resources.compose_multiplatform
import com.farimarwat.bookapp.di.platformModule
import com.farimarwat.bookapp.di.sharedModule
import com.farimarwat.bookapp.presentation.BookViewModel
import com.farimarwat.bookapp.presentation.components.SearchBar
import org.koin.compose.KoinApplication
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
@Preview
fun App(viewModel: BookViewModel = koinInject<BookViewModel>()) {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }

        Column(
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(top = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchBar()
        }
    }
}