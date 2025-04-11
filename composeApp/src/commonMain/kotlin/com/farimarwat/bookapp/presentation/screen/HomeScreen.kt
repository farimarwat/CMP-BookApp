package com.farimarwat.bookapp.presentation.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.farimarwat.bookapp.domain.model.Book
import com.farimarwat.bookapp.presentation.components.BookItem
import com.farimarwat.bookapp.presentation.state.UiState
import com.farimarwat.bookapp.presentation.viewmodel.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onBookSelected:(Book)->Unit ={}
    ){
    val books by viewModel.books.collectAsStateWithLifecycle()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit){
        viewModel.getBooks()
    }
    when(uiState){
        UiState.Empty -> {}
        is UiState.Error -> {

        }
        UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator(
                    color = MaterialTheme.colorScheme.surface
                )
            }
        }
        is UiState.Success<*> -> {
            Box(
                modifier = Modifier
            ){
                LazyColumn {
                    items(
                        items = books,
                        key = {
                            it.key
                        }
                    ){item ->
                        Box(
                            modifier = Modifier
                                .animateItem(
                                    placementSpec = tween(500)
                                )
                        ){
                            BookItem(book = item){
                                onBookSelected(item)
                            }
                        }
                    }
                }
            }
        }
    }
}