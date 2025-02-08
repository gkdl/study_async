package dev.be.async.controller

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.slf4j.MDC
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MdcController {
    companion object {
        private val log: Logger = LoggerFactory.getLogger(MdcController::class.java)
    }


    @GetMapping("/mdc")
    fun demoErrorDecoder(
    ) : String {
        //로그에서 해당 값에 저장되어 잇는 값을 동적으로 가져와서 출력시키기 위해 사용
        MDC.put("job", "dev")
        log.trace("log --> TRACE")
        log.debug("log --> DEBUG")
        log.info("log --> INFO")
        log.warn("log --> WARN")
        log.error("log --> ERROR")
        MDC.clear()
        return "mdc"
    }
}