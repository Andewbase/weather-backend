package ru.weathertestings.features.registr

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import ru.weathertestings.database.city.CityDTO
import ru.weathertestings.database.city.CityModel
import ru.weathertestings.features.CreateCity
import ru.weathertestings.utils.isValidName

class CityController(val call: ApplicationCall) {

    suspend fun registrNewCity(){
        val receive = call.receive(CreateCity::class)
        if (!receive.name.isValidName()){
            call.respond(HttpStatusCode.BadRequest, "Name is not valid")
        }

        val cityDTO = CityModel.fetchCity(receive.name)

       if (cityDTO != null){
           call.respond(HttpStatusCode.Conflict, "User already exist")
       }else{
            CityModel.insert(
                CityDTO(
                    name = receive.name,
                    type = receive.type
                )
            )
       }
    }

    suspend fun perfomCity(){
        val receive = call.receive<CreateCity>()
        CityModel.fetchCity(receive.name)
    }

}