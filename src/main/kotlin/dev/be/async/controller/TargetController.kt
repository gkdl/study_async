package dev.be.async.controller

import dev.be.async.common.dto.BaseRequestInfo
import dev.be.async.common.dto.BaseResponseInfo
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/target_server")
class TargetController {
    @GetMapping("/get")
    fun get(
        @RequestHeader("CustomHeaderName") header: String,
        @RequestParam("name") name: String,
        @RequestParam("age") age: Long,
    ) : BaseResponseInfo {
        return BaseResponseInfo(
            name = name,
            age = age,
            header = header
        )
    }

    @PostMapping("/post")
    fun get(
        @RequestHeader("CustomHeaderName") header: String,
        @RequestBody body: BaseRequestInfo,
    ) : BaseResponseInfo {
        return BaseResponseInfo(
            name = body.name,
            age = body.age,
            header = header
        )
    }

    @GetMapping("/error")
    fun demoErrorDecoder(
    ) : ResponseEntity<Any> {
        return ResponseEntity<Any>(HttpStatus.NOT_FOUND)
    }
}