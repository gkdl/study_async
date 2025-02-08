package dev.be.async.config

import dev.be.async.feign.logger.FeignCustomLogger
import feign.Logger
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {
    @Bean
    fun feignLogger() : Logger {
        return FeignCustomLogger()
    }
}