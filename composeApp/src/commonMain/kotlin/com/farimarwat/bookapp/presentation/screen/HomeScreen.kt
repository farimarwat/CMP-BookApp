package com.farimarwat.bookapp.presentation.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.farimarwat.bookapp.domain.model.Book
import com.farimarwat.bookapp.presentation.components.BookItem

@Composable
fun HomeScreen(list:List<Book>){
    AnimatedContent(
        targetState = list.size > 0
    ){
        if(it){
           Box(
               modifier = Modifier
           ){
               LazyColumn {
                   items(
                       items = list,
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
                           BookItem(book = item)
                       }
                   }
               }
           }
        }
    }
}