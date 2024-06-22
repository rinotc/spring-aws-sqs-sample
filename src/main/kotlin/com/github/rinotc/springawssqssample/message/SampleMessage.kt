package com.github.rinotc.springawssqssample.message

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule

data class SampleMessage(
    val id: String,
    val no: Int,
    val message: String
) {
    fun asJson(): String {
        val mapper = ObjectMapper().registerModule(KotlinModule.Builder().build())
        return mapper.writeValueAsString(this)
    }
}