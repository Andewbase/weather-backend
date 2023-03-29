package ru.weathertestings.database.season

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

object SeasonModel: Table("season") {
    private val name = SeasonModel.varchar("name", 10)
    private val nameMonthOne = SeasonModel.varchar("name_month_one", 10)
    private val nameMonthTwo = SeasonModel.varchar("name_month_two", 10)
    private val nameMonthThree = SeasonModel.varchar("name_month_three", 10)
    private val temperatureMonthOne = SeasonModel.double("temperature_month_one")
    private val temperatureMonthTwo = SeasonModel.double("temperature_month_two")
    private val temperatureMonthThree = SeasonModel.double("temperature_month_three")


    fun insert(seasonDTO: SeasonDTO){
        transaction {
            SeasonModel.insert {
                it[name] = seasonDTO.name
                it[nameMonthOne] = seasonDTO.nameMonthOne
                it[nameMonthTwo] = seasonDTO.nameMonthTwo
                it[nameMonthThree] = seasonDTO.nameMonthThree
                it[temperatureMonthOne] = seasonDTO.temperatureMonthOne
                it[temperatureMonthTwo] = seasonDTO.temperatureMonthTwo
                it[temperatureMonthThree] = seasonDTO.temperatureMonthThree
            }
        }
    }

    fun fetchSeason(name: String): SeasonDTO?{
        return try{
            transaction {
                val seasonModel = SeasonModel.select{ SeasonModel.name.eq(name) }.single()
                SeasonDTO(
                    name = seasonModel[SeasonModel.name],
                    nameMonthOne = seasonModel[nameMonthOne],
                    nameMonthTwo = seasonModel[nameMonthTwo],
                    nameMonthThree = seasonModel[nameMonthThree],
                    temperatureMonthOne = seasonModel[temperatureMonthOne],
                    temperatureMonthTwo = seasonModel[temperatureMonthTwo],
                    temperatureMonthThree = seasonModel[temperatureMonthThree]
                )
            }
        }catch (e: Exception){
            null
        }
    }



}