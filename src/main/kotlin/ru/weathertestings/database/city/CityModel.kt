package ru.weathertestings.database.city

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object CityModel: Table("city") {
    private val name = CityModel.varchar("name", 25)
    private val type = CityModel.integer("type")

    fun insert(cityDTO: CityDTO){
        transaction {
            CityModel.insert {
                it[name] = cityDTO.name
                it[type] = cityDTO.type
            }
        }
    }

    fun fetchCity(name: String): CityDTO?{
        return try{
            transaction {
                val cityModel = CityModel.select{ CityModel.name.eq(name) }.single()
                CityDTO(
                    name = cityModel[CityModel.name],
                    type = cityModel[type]
                )
            }
        }catch (e: Exception){
          null
        }
    }
}