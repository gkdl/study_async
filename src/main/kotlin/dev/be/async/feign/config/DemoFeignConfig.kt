package dev.be.async.feign.config

import dev.be.async.decoder.DemoFeignErrorDecoder
import dev.be.async.feign.interceptor.DemoFeignInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DemoFeignConfig {
    @Bean
    fun feignInterceptor(): DemoFeignInterceptor {
        return DemoFeignInterceptor()
    }

    @Bean
    fun demoErrorDecoder(): DemoFeignErrorDecoder {
        return DemoFeignErrorDecoder()
    }
}