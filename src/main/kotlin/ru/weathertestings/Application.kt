package ru.weathertestings

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.cio.*
import org.jetbrains.exposed.sql.Database
import ru.weathertestings.features.routing.configureCreateCity
import ru.weathertestings.features.routing.configureCreateSeason
import ru.weathertestings.plugins.*

fun main() {

    Database.connect("jdbc:postgresql://localhost:5432/weather", driver = "org.postgresql.Driver",
        user = "postgres", password = "2109")

    embeddedServer(CIO, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
    configureSerialization()
    configureCreateCity()
    configureCreateSeason()
}
