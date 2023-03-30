package ru.weathertestings.features.season

import kotlinx.serialization.Serializable

@Serializable
data class CreateSeason(
    val name: String,
    val nameMonthOne: String,
    val nameMonthTwo: String,
    val nameMonthThree: String,
    val temperatureMonthOne: Double,
    val temperatureMonthTwo: Double,
    val temperatureMonthThree: Double
)
