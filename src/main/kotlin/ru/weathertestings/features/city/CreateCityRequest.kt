package ru.weathertestings.features.city

import kotlinx.serialization.Serializable

@Serializable
data class CreateCityRequest(
    val name: String,
    val type: Int
)

@Serializable
data class CreateCityResponce(
    val name: String,
    val type: Int
)
