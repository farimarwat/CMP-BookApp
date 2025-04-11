package com.farimarwat.bookapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.farimarwat.bookapp.presentation.viewmodel.DetailsViewModel

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel,
    onBackPressed:()->Unit={}
){
    val book by viewModel.currentBook.collectAsStateWithLifecycle()
    book?.let{
        Column (
            modifier = Modifier
                .fillMaxSize()
        ){
            Box(
                modifier = Modifier
                    .height(400.dp)
            ){
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ){
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxSize()
                        ,
                        model = it.getCoverImageUrl(),
                        contentDescription = it.title,
                        contentScale = ContentScale.Crop
                    )
                    IconButton(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(Alignment.TopStart)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary)
                        ,
                        onClick = {onBackPressed()}
                    ){
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                            contentDescription = it.title,
                            tint = MaterialTheme.colorScheme.surface
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .padding(bottom = 50.dp)
                        .align(Alignment.BottomCenter),
                    elevation = CardDefaults.cardElevation(8.dp)
                ){
                    AsyncImage(
                        modifier = Modifier
                            .height(150.dp),
                        model = it.getCoverImageUrl(),
                        contentDescription = it.title,
                        contentScale = ContentScale.Fit
                    )
                }
            }
            Card (
                modifier = Modifier
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(18.dp)
            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(8.dp)
                ){
                    Text(
                        text = it.title,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row {
                        it.authors.forEach { author ->
                            AssistChip(
                                label = {
                                    Text(author)
                                },
                                enabled = false,
                                onClick = {}
                            )
                        }
                    }

                    Text(
                        text = it.description,
                        maxLines = 10
                    )
                }
            }
        }
    }
}