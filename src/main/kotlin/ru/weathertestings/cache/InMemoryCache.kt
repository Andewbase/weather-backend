package ru.weathertestings.cache

import ru.weathertestings.features.CreateCity

object InMemoryCache {

    var cityList: MutableList<CreateCity> = mutableListOf()

}