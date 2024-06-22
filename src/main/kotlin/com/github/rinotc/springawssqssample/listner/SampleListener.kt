package com.github.rinotc.springawssqssample.listner

import com.github.rinotc.springawssqssample.message.SampleMessage
import io.awspring.cloud.sqs.annotation.SqsListener
import org.springframework.stereotype.Component


@Component
class SampleListener {
    @SqsListener("sample-queue")
    fun listen(message: String) {
        println("Received message: $message")
    }

    @SqsListener("sample-object-queue")
    fun listenObject(message: SampleMessage) {
        println("Received object message: $message")
        println("className is ${message.javaClass.name}")
    }
}