package br.andre.springtransactionskotlin.service

import br.andre.springtransactionskotlin.domain.entity.Transaction
import br.andre.springtransactionskotlin.domain.repository.TransactionRepository
import br.andre.springtransactionskotlin.dto.TransactionRequestDTO
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.DoubleSummaryStatistics
import java.util.concurrent.ConcurrentHashMap

@Service
class TransactionService(
    private val transactionRepository: TransactionRepository,
) {

    fun createTransaction(dto: TransactionRequestDTO) {
        val transaction = Transaction(
            value = dto.value,
            dateTime = dto.dateTime
        )

        transactionRepository.save(transaction)
    }

    fun clearTransactions() {
        transactionRepository.deleteAll()
    }

    fun getStatistics(seconds: Long): DoubleSummaryStatistics {
        val limit = OffsetDateTime.now().minusSeconds(seconds)
        val transactions = transactionRepository.findByDateTimeAfter(limit)

        return transactions.stream()
            .mapToDouble { it.value }
            .summaryStatistics()
    }

}