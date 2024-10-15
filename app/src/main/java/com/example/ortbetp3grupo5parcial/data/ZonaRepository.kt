package com.example.ortbetp3grupo5parcial.data

import com.example.ortbetp3grupo5parcial.models.Zona

object ZonaRepository {
    private val zonas = listOf(
        Zona(1, "Banasree"),
        Zona(2, "Gulshan"),
        Zona(3, "Uttara"),
        Zona(4, "Banani")
    ).sortedBy { it.nombre }

    fun getZonas(): List<Zona> = zonas
}