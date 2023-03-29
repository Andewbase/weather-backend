package ru.weathertestings.features.routing

import io.ktor.server.application.*
import io.ktor.server.routing.*
import ru.weathertestings.features.registr.SeasonController

fun Application.configureCreateSeason(){
    routing {
        post("create_season"){
            val seasonController = SeasonController(call)
            seasonController.registrNewSeason()
        }
    }
}