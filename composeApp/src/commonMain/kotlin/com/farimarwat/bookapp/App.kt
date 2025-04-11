package com.farimarwat.bookapp

import androidx.compose.animation.AnimatedVisibility
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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview

import com.farimarwat.bookapp.presentation.viewmodel.HomeViewModel
import com.farimarwat.bookapp.presentation.components.SearchBar
import com.farimarwat.bookapp.presentation.screen.DetailsScreen
import com.farimarwat.bookapp.presentation.screen.HomeScreen
import com.farimarwat.bookapp.presentation.screen.Screen
import com.farimarwat.bookapp.presentation.ui.getColorScheme
import com.farimarwat.bookapp.presentation.viewmodel.DetailsViewModel
import kotlinx.coroutines.launch

import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App(
    homeViewModel: HomeViewModel = koinViewModel(),
    detailsViewModel:DetailsViewModel = koinViewModel()
) {
    MaterialTheme(
        colorScheme = getColorScheme()
    ) {
        val navController = rememberNavController()
        val scope = rememberCoroutineScope()
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
            rememberTopAppBarState()
        )
        var showSearchBar by remember { mutableStateOf(true) }
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                AnimatedVisibility(
                    visible = showSearchBar
                ){
                    SearchBar(
                        scrollBehavior = scrollBehavior,
                        onSearch = {

                        },
                        onFilter = {
                            scope.launch {
                                homeViewModel.filter(it)
                            }
                        },
                        onClear = {
                            homeViewModel.filter("")
                        }
                    )
                }
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
                        HomeScreen(homeViewModel){
                            detailsViewModel.setCurrentBook(it)
                            navController.navigate(Screen.Details.route)
                            showSearchBar = false
                        }
                    }
                    composable(
                        route = Screen.Details.route
                    ){
                        DetailsScreen(detailsViewModel){
                            showSearchBar = true
                            navController.navigateUp()
                        }
                    }
                }
            }
        }

    }
}