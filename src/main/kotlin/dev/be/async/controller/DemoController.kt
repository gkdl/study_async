package dev.be.async.controller

import dev.be.async.service.DemoService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController(
    private val demoService: DemoService,
    @Value("\${override.value}") private val value: String
){
    companion object {
        private val log: Logger = LoggerFactory.getLogger(DemoController::class.java)
    }

    @GetMapping("/get")
    fun get(

    ) : String {
        return demoService.get()
    }

    @GetMapping("/post")
    fun post(

    ) : String {
        return demoService.post()
    }

    @GetMapping("/error")
    fun errorDecoder(

    ) : String {
        return demoService.errorDecoder()
    }

    @GetMapping("/demo")
    fun demo(

    ) : String {
        log.trace("log --> TRACE")
        log.debug("log --> DEBUG")
        log.info("log --> INFO")
        log.warn("log --> WARN")
        log.error("log --> ERROR")
        return "demo"
    }

    @GetMapping("/value")
    fun valueTest(

    ) : String {
        log.trace("log --> TRACE")

        return "demo " + value
    }
}