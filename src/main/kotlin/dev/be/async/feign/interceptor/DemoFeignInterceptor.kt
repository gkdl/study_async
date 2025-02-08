package dev.be.async.feign.interceptor

import feign.Request.HttpMethod
import feign.RequestInterceptor
import feign.RequestTemplate
import org.apache.commons.lang3.StringUtils

class DemoFeignInterceptor(

) :RequestInterceptor {
    override fun apply(template: RequestTemplate) {
        //get요청일 경우
        if(template.method() == HttpMethod.GET.name) {
            System.out.println("[GET] [DemoFeignInterceptor] queries : " + template.queries())
            return
        }
        //post 요청일 경우
        val encodedRequestBody = StringUtils.toEncodedString(template.body(), Charsets.UTF_8)
        System.out.println("[POST] [DemoFeignInterceptor] requestBody : " + encodedRequestBody)

        val convertRequestBody = encodedRequestBody
        template.body(convertRequestBody)
    }
}