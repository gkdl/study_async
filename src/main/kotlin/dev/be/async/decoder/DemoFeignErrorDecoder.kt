package dev.be.async.decoder

import feign.Response
import feign.codec.ErrorDecoder
import org.springframework.http.HttpStatus

class DemoFeignErrorDecoder(
    private val errorDecoder: ErrorDecoder = ErrorDecoder.Default()
) : ErrorDecoder {
    override fun decode(p0: String?, p1: Response?): Exception {
        val httpStatus = p1?.let { HttpStatus.resolve(it.status()) }

        if(httpStatus == HttpStatus.NOT_FOUND) {
            System.out.println("[DemoFeignErrorDecode] Http Status = " + httpStatus)
            throw RuntimeException(String.format("[RuntimeException] Http Status is %s", httpStatus))
        }

        return errorDecoder.decode(p0, p1)
    }
}