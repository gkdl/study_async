package dev.be.async.service

import dev.be.async.common.dto.BaseRequestInfo
import dev.be.async.feign.client.DemoFeignClient
import org.springframework.stereotype.Service

@Service
class DemoService(
    val demoFeignClient: DemoFeignClient
) {
    fun get() : String {
        val response =  demoFeignClient.callGet("CustomHeaderName", "CustomnName", 1L)
        System.out.println("Name : " + response.body?.name)
        System.out.println("Age : " + response.body?.age)
        System.out.println("Header : " + response.body?.header)

        return "get"
    }

    fun post() : String {
        val baseRequestInfo = BaseRequestInfo(
            name = "customName",
            age = 2L,
            header = null
        )

        val response =  demoFeignClient.callPost("CustomHeaderName", baseRequestInfo)
        System.out.println("Name : " + response.body?.name)
        System.out.println("Age : " + response.body?.age)
        System.out.println("Header : " + response.body?.header)

        return "post"
    }

    fun errorDecoder() : String {
        demoFeignClient.callErrorDecoder()

        return "post"
    }
}