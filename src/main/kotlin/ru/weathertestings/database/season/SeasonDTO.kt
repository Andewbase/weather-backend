package ru.weathertestings.database.season

data class SeasonDTO(
    val name: String,
    val nameMonthOne: String,
    val nameMonthTwo: String,
    val nameMonthThree: String,
    val temperatureMonthOne: Double,
    val temperatureMonthTwo: Double,
    val temperatureMonthThree: Double
)
