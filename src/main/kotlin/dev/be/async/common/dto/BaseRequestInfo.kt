package dev.be.async.common.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class BaseRequestInfo (
    val name: String,
    val age: Long,
    val header: String?,
)