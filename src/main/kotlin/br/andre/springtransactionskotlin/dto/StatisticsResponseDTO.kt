package br.andre.springtransactionskotlin.dto

data class StatisticsResponseDTO(
    val count: Long,
    val sum: Double,
    val avg: Double,
    val min: Double,
    val max: Double
)
