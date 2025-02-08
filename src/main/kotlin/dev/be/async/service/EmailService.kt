package dev.be.async.service

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class EmailService {
    @Async("defaultTaskExecutor")
    fun sendMail() {
        System.out.println("[sendMail]  :: ] " + Thread.currentThread().name)
    }

    @Async("messagingTaskExecutor")
    fun sendMailWithCustomThreadPool() {
        System.out.println("[messagingTaskExecutor]  :: ] " + Thread.currentThread().name)
    }
}