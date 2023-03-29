package ru.weathertestings.features

import kotlinx.serialization.Serializable

@Serializable
data class CreateCity(
    val name: String,
    val type: Int
)
