package dev.be.async

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class AsyncApplication

fun main(args: Array<String>) {
    runApplication<AsyncApplication>(*args)
}
