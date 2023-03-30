package ru.weathertestings.database.city

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
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

    fun fetchAllCity(): List<CityDTO>{
        return try{
            transaction {
               CityModel.selectAll().toList().map {
                   CityDTO(
                       name = it[name],
                       type = it[type]
                   )
               }
            }
        }catch (e: Exception){
          emptyList()
        }
    }
}