package ru.weathertestings.cache

import ru.weathertestings.features.city.CreateCityRequest

object InMemoryCache {

    var cityList: MutableList<CreateCityRequest> = mutableListOf()

}