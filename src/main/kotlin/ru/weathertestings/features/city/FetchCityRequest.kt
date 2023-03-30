package ru.weathertestings.features.city

import kotlinx.serialization.Serializable


@Serializable
data class FetchCityRequest (
    val searchQuery: String
)