package com.farimarwat.bookapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Description(
    val type:String,
    val value:String
)
