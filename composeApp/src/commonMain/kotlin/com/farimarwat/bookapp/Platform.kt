package com.farimarwat.bookapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform