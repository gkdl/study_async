package dev.be.async.feign.client

import dev.be.async.common.dto.BaseRequestInfo
import dev.be.async.common.dto.BaseResponseInfo
import dev.be.async.feign.config.DemoFeignConfig
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestParam

@FeignClient (
    name = "demo-client",
    url = "\${feign.url.prefix}",
    configuration = [DemoFeignConfig::class]
)
interface DemoFeignClient {
    @GetMapping("/get")
    fun callGet(
        @RequestHeader("CustomHeaderName") customHeader: String,
        @RequestParam("name") name: String,
        @RequestParam("age") aget: Long,
    ) : ResponseEntity<BaseResponseInfo>

    @PostMapping("/post")
    fun callPost(
        @RequestHeader("CustomHeaderName") customHeader: String,
        @RequestBody baseRequest: BaseRequestInfo,
    ) : ResponseEntity<BaseResponseInfo>

    @GetMapping("/error")
    fun callErrorDecoder(
    ) : ResponseEntity<BaseResponseInfo>
}