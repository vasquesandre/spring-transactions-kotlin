package br.andre.springtransactionskotlin.service

import br.andre.springtransactionskotlin.domain.entity.Transaction
import br.andre.springtransactionskotlin.dto.TransactionRequestDTO
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.DoubleSummaryStatistics
import java.util.concurrent.ConcurrentHashMap

@Service
class TransactionService {

    val transactions = ConcurrentHashMap<String, Transaction>()

    fun createTransaction(dto: TransactionRequestDTO) {
        val transaction = Transaction(
            value = dto.value,
            dateTime = dto.dateTime
        )

        transactions[transaction.id] = transaction
    }

    fun clearTransactions() {
        transactions.clear()
    }

    fun getStatistics(seconds: Long): DoubleSummaryStatistics {
        val limit = OffsetDateTime.now().minusSeconds(seconds)

        return transactions.values
            .filter { it.dateTime.isAfter(limit) }
            .map { it.value }
            .stream()
            .mapToDouble { it }
            .summaryStatistics()
    }

}