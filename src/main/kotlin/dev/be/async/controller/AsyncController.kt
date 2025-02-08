package dev.be.async.controller

import dev.be.async.service.AsyncService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AsyncController (
    val asyncService: AsyncService
) {

    @GetMapping("/1")
    fun asyncCall_1(

    ) : String {
        asyncService.asyncCall_1()
        return "success"
    }

    @GetMapping("/2")
    fun asyncCall_2(

    ) : String {
        asyncService.asyncCall_2()
        return "success"
    }

    @GetMapping("/3")
    fun asyncCall_3(

    ) : String {
        asyncService.asyncCall_3()
        return "success"
    }
}