package ru.weathertestings.features.registr

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import ru.weathertestings.database.city.CityDTO
import ru.weathertestings.database.city.CityModel
import ru.weathertestings.features.city.CreateCityRequest
import ru.weathertestings.features.city.FetchCityRequest
import ru.weathertestings.utils.isValidName

class CityController(private val call: ApplicationCall) {

    suspend fun registrNewCity(){
        val receive = call.receive(CreateCityRequest::class)
        if (!receive.name.isValidName()){
            call.respond(HttpStatusCode.BadRequest, "Name is not valid")
        }
            CityModel.insert(
                CityDTO(
                    name = receive.name,
                    type = receive.type
                )
            )
    }

    suspend fun perfomCitySearch(){
        val request = call.receive<FetchCityRequest>()
        if (request.searchQuery.isBlank()){
            call.respond(CityModel.fetchAllCity())
        }else{
            call.respond(CityModel.fetchAllCity().filter { it.name.contains(request.searchQuery, ignoreCase = true)})
        }
    }

}