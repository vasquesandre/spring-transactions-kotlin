package br.andre.springtransactionskotlin.dto

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.PastOrPresent
import jakarta.validation.constraints.Positive
import java.time.OffsetDateTime

data class TransactionRequestDTO(
    @field:NotNull
    @field:Positive
    val value: Double,

    @field:NotBlank
    @field:PastOrPresent
    val dateTime: OffsetDateTime
)
