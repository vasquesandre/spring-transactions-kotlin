package br.andre.springtransactionskotlin.domain.entity

import java.time.OffsetDateTime
import java.util.UUID

class Transaction (
    val id: String = UUID.randomUUID().toString(),
    val value: Double,
    val dateTime: OffsetDateTime
)