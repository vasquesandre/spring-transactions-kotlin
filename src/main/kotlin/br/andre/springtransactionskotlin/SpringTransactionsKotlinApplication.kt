package br.andre.springtransactionskotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringTransactionsKotlinApplication

fun main(args: Array<String>) {
    runApplication<SpringTransactionsKotlinApplication>(*args)
}
