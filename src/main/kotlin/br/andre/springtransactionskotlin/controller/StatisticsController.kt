package br.andre.springtransactionskotlin.controller

import br.andre.springtransactionskotlin.dto.StatisticsResponseDTO
import br.andre.springtransactionskotlin.service.TransactionService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.DoubleSummaryStatistics

@RestController
@RequestMapping("/statistics")
class StatisticsController(
    private val transactionService: TransactionService,
) {

    val log: Logger = LoggerFactory.getLogger(StatisticsController::class.java)

    @GetMapping
    fun getStatistics(@RequestParam(required = false) seconds: Long?): ResponseEntity<StatisticsResponseDTO> {
        val seconds = seconds ?: 60

        log.info("STATISTICS GET REQUEST with $seconds seconds")

        val statistics: DoubleSummaryStatistics = transactionService.getStatistics(seconds)

        return ResponseEntity.ok(StatisticsResponseDTO(
            statistics.count,
            statistics.sum,
            statistics.average,
            statistics.min,
            statistics.max
        ))
    }

}