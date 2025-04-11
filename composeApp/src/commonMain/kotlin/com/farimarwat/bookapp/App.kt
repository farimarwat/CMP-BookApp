package com.farimarwat.bookapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

import com.farimarwat.bookapp.presentation.viewmodel.HomeViewModel
import com.farimarwat.bookapp.presentation.components.SearchBar
import com.farimarwat.bookapp.presentation.screen.HomeScreen
import com.farimarwat.bookapp.presentation.screen.Screen
import com.farimarwat.bookapp.presentation.ui.getColorScheme
import kotlinx.coroutines.launch

import org.koin.compose.koinInject

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App(viewModel: HomeViewModel = koinInject<HomeViewModel>()) {
    MaterialTheme(
        colorScheme = getColorScheme()
    ) {
        val navController = rememberNavController()
        val scope = rememberCoroutineScope()
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
            rememberTopAppBarState()
        )
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                SearchBar(
                    scrollBehavior = scrollBehavior,
                    onSearch = {

                    },
                    onFilter = {
                        scope.launch {
                            viewModel.filter(it)
                        }
                    },
                    onClear = {
                        viewModel.filter("")
                    }
                )
            }
        ) { padding ->
            Column(
                Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(padding),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                NavHost(
                    navController = navController,
                    startDestination = Screen.HomeScreen.route
                ){
                    composable(
                        route = Screen.HomeScreen.route
                    ){
                        HomeScreen(viewModel)
                    }
                }
            }
        }

    }
}