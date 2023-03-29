package ru.weathertestings.features.registr

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import ru.weathertestings.database.season.SeasonDTO
import ru.weathertestings.database.season.SeasonModel
import ru.weathertestings.features.CreateSeason
import ru.weathertestings.utils.isValidName

class SeasonController(val call: ApplicationCall) {


    suspend fun registrNewSeason(){
        val registSeason = call.receive<CreateSeason>()
        if (!registSeason.name.isValidName()){
            call.respond(HttpStatusCode.BadRequest, "Name is not valid")
        }

        val seasonDTO = SeasonModel.fetchSeason(registSeason.name)

        if (seasonDTO != null){
            call.respond(HttpStatusCode.Conflict, "User already exist")
        }else{
            SeasonModel.insert(
                SeasonDTO(
                   name = registSeason.name,
                   nameMonthOne = registSeason.nameMonthOne,
                   nameMonthTwo = registSeason.nameMonthOne,
                   nameMonthThree = registSeason.nameMonthOne,
                   temperatureMonthOne = registSeason.temperatureMonthOne,
                   temperatureMonthTwo = registSeason.temperatureMonthTwo,
                   temperatureMonthThree = registSeason.temperatureMonthThree
                )
            )
        }
    }

}