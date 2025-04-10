package com.farimarwat.bookapp

import androidx.compose.ui.window.ComposeUIViewController
import com.farimarwat.bookapp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }