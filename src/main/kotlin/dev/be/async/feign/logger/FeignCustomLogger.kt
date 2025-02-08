package dev.be.async.feign.logger

import feign.Logger
import feign.Request
import feign.Response
import feign.Util

class FeignCustomLogger(
    private val DEFAULT_SLOW_API_TIME:Int = 3000,
    private val SLOW_API_NOTICE:String = "Slow API",

) : Logger() {
    override fun log(p0: String?, p1: String?, vararg p2: Any?) {
        System.out.println(String.format(methodTag(p0) + p1, *p2))
    }

    override fun logRequest(configKey: String?, logLevel: Level?, request: Request?) {
        System.out.println("[logRequest] : " + request)
    }

    override fun logAndRebufferResponse(
        configKey: String?,
        logLevel: Level?,
        response: Response?,
        elapsedTime: Long
    ): Response? {
        val protocolVersion = resolveProtocolVersion(response!!.protocolVersion())
        val reason =
            if (response.reason() != null && logLevel!!.compareTo(Level.NONE) > 0) " " + response.reason() else ""
        val status = response.status()
        this.log(configKey, "<--- %s %s%s (%sms)", protocolVersion, status, reason, elapsedTime)
        if (logLevel!!.ordinal >= Level.HEADERS.ordinal) {
            val var9: Iterator<*> = response.headers().keys.iterator()

            while (true) {
                var field: String?
                do {
                    if (!var9.hasNext()) {
                        var bodyLength = 0
                        if (response.body() != null && status != 204 && status != 205) {
                            if (logLevel.ordinal >= Level.FULL.ordinal) {
                                this.log(configKey, "")
                            }

                            val bodyData = Util.toByteArray(response.body().asInputStream())
                            Util.ensureClosed(response.body())
                            bodyLength = bodyData.size
                            if (logLevel.ordinal >= Level.FULL.ordinal && bodyLength > 0) {
                                this.log(configKey, "%s", Util.decodeOrDefault(bodyData, Util.UTF_8, "Binary data"))
                            }

                            if(elapsedTime> DEFAULT_SLOW_API_TIME) {
                                log(configKey, "[%s] elapsedTime : %s", SLOW_API_NOTICE, elapsedTime)
                            }

                            this.log(configKey, "<--- END HTTP (%s-byte body)", bodyLength)
                            return response.toBuilder().body(bodyData).build()
                        }

                        this.log(configKey, "<--- END HTTP (%s-byte body)", bodyLength)
                        return response
                    }

                    field = var9.next() as String?
                } while (!this.shouldLogResponseHeader(field))

                val var11: Iterator<*> = Util.valuesOrEmpty(response.headers(), field).iterator()

                while (var11.hasNext()) {
                    val value = var11.next() as String
                    this.log(configKey, "%s: %s", field, value)
                }
            }
        } else {
            return response
        }
    }
}