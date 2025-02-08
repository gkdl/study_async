package dev.be.async.service

import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service

@Service
class AsyncService (
    private val emailService: EmailService
){
    fun asyncCall_1(

    ) {
        System.out.println("[asyncCall_1]  :: ] " + Thread.currentThread().name)
        emailService.sendMail()
        emailService.sendMailWithCustomThreadPool()
        System.out.println("[asyncCall_1]  :: ] " + Thread.currentThread().name)
    }

    fun asyncCall_2(

    ) {
        // Bean으로 등록하지 않고 인스턴스 선언으로 사용했기 때문에 Spring FrameWork의 도움을 받을수 없다.
        System.out.println("[asyncCall_2]  :: ] " + Thread.currentThread().name)
        val emailService2 = EmailService()
        emailService2.sendMail()
        emailService2.sendMailWithCustomThreadPool()
    }

    fun asyncCall_3(

    ) {
        //Bean 안의 Method를 바로 호출하면 Spring FrameWork의 도움을 받을수 없다.
        System.out.println("[asyncCall_3]  :: ] " + Thread.currentThread().name)
        sendMail()
    }

    @Async
    fun sendMail() {
        System.out.println("[sendMail]  :: ] " + Thread.currentThread().name)
    }

}