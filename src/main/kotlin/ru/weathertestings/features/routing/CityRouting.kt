package ru.weathertestings.features.routing

import io.ktor.server.application.*
import io.ktor.server.routing.*
import ru.weathertestings.features.registr.CityController

fun Application.configureCreateCity(){
    routing {
        post("/create_city"){
            val cityController = CityController(call)
            cityController.registrNewCity()
        }

        post("/city/search"){
            val cityController = CityController(call)
            cityController.perfomCitySearch()
        }
    }
}