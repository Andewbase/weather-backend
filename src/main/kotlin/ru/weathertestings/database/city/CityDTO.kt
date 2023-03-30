package ru.weathertestings.database.city

import kotlinx.serialization.Serializable

@Serializable
data class CityDTO(
    val name: String,
    val type: Int
)
