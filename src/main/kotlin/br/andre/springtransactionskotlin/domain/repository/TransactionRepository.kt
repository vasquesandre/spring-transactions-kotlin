package br.andre.springtransactionskotlin.domain.repository

import br.andre.springtransactionskotlin.domain.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import java.time.OffsetDateTime

interface TransactionRepository: JpaRepository<Transaction, String> {
    fun findByDateTimeAfter(limit: OffsetDateTime): List<Transaction>
}