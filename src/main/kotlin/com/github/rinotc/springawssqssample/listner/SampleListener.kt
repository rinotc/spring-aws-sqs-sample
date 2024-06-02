package com.github.rinotc.springawssqssample.listner

import io.awspring.cloud.sqs.annotation.SqsListener
import org.springframework.stereotype.Component


@Component
class SampleListener {
    @SqsListener("sample-queue")
    fun listen(message: String) {
        println("Received message: $message")
    }
}