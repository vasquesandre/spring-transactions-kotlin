package br.andre.springtransactionskotlin.domain.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.OffsetDateTime
import java.util.UUID

@Entity
@Table(name = "transactions")
class Transaction (
    @Id
    val id: String = UUID.randomUUID().toString(),
    val value: Double,
    val dateTime: OffsetDateTime
)