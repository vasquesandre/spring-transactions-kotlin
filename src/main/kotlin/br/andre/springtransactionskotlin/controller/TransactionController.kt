package br.andre.springtransactionskotlin.controller

import br.andre.springtransactionskotlin.dto.TransactionRequestDTO
import br.andre.springtransactionskotlin.service.TransactionService
import jakarta.validation.Valid
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/transaction")
class TransactionController(
    private val transactionService: TransactionService
) {

    val log: Logger = LoggerFactory.getLogger(TransactionController::class.java)

    fun postTransaction(@RequestBody @Valid request: TransactionRequestDTO): ResponseEntity<Void> {
        log.info("POST TRANSACTION REQUEST")

        transactionService.createTransaction(request)
        log.info("TRANSACTION CREATED")

        return ResponseEntity(HttpStatus.CREATED)
    }

    fun clearTransactions(): ResponseEntity<Void> {
        log.info("CLEAR TRANSACTIONS REQUEST")

        transactionService.clearTransactions()
        log.info("CLEAR SUCCESS")

        return ResponseEntity.ok().build()
    }

}