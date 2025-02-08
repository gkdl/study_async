package dev.be.async.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class QueryController2 {
    companion object {
        private val log: Logger = LoggerFactory.getLogger("SQL_LOG2")
    }

    @GetMapping("/query2")
    fun demoErrorDecoder(
    ) : String {
        log.trace("log --> TRACE")
        log.debug("log --> DEBUG")
        log.info("log --> INFO")
        log.warn("log --> WARN")
        log.error("log --> ERROR")
        return "query2"
    }
}