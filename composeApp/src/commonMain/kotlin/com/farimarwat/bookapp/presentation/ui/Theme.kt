package com.farimarwat.bookapp.presentation.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color



val LightColorTheme = lightColorScheme(
    primary = Color(0xFF00796B),       // Rich Teal
    onPrimary = Color.White,

    secondary = Color(0xFF4DB6AC),     // Muted Teal
    onSecondary = Color.Black,

    tertiary = Color(0xFF009688),      // Fresh Teal Accent

    background = Color(0xFF00796B),    // Soft off-white with a teal tint
    onBackground = Color(0xFF004D40),  // Dark Teal for text (better contrast)

    surface = Color(0xFFE0F2F1),       // Pale Teal for cards and sheets
    onSurface = Color(0xFF00332E),     // Deep greenish teal for text

    error = Color(0xFFD32F2F),         // Strong Red
    onError = Color.White
)


val DarkColorTheme = darkColorScheme(
    primary = Color(0xFF80CBC4),       // Soft Teal
    onPrimary = Color.Black,

    secondary = Color(0xFF4DB6AC),     // Calm Aqua
    onSecondary = Color.Black,

    tertiary = Color(0xFF1DE9B6),      // Neon Mint accent

    background = Color(0xFF121212),    // Standard dark
    onBackground = Color(0xFFE0F2F1),  // Soft Teal white

    surface = Color(0xFF1E1E1E),       // Slightly lighter surface
    onSurface = Color(0xFFB2DFDB),     // Muted aqua text

    error = Color(0xFFEF5350),         // Softer Red
    onError = Color.Black
)


@Composable
fun getColorScheme():ColorScheme{
    return if(isSystemInDarkTheme()) DarkColorTheme else LightColorTheme
}