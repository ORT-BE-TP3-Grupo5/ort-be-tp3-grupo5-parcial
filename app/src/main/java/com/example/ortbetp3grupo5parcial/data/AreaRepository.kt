package com.example.ortbetp3grupo5parcial.data

import com.example.ortbetp3grupo5parcial.models.Area

object AreaRepository {
    private val areas = listOf(
        Area(1, "Residential"),
        Area(2, "Commercial"),
        Area(3, "Industrial")
    ).sortedBy { it.nombre }

    fun getAreas(): List<Area> = areas
}
