package com.farimarwat.bookapp.presentation.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.farimarwat.bookapp.domain.model.Book
import com.farimarwat.bookapp.presentation.components.BookItem

@Composable
fun HomeScreen(list:List<Book>){
    LazyColumn {
        items(
            items = list,
            key = {
                it.key
            }
        ){item ->
            BookItem(item)
        }
    }
}