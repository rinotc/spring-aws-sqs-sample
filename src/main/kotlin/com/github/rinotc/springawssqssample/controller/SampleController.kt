package com.github.rinotc.springawssqssample.controller

import com.github.rinotc.springawssqssample.message.SampleMessage
import io.awspring.cloud.sqs.operations.SendResult
import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class SampleController(
    private val template: SqsTemplate
) {
    private var counter = 0

    @PostMapping("/send-message")
    fun sendStringMessage(@RequestBody request: Request) {
        val message = request.message
        val sendResult: SendResult<String> = template.send("sample-queue", message)
        println("Message sent: $sendResult")
    }

    @PostMapping("/send-object-message")
    fun sendObjectMessage(@RequestBody request: Request) {
        val message = SampleMessage(
            id = UUID.randomUUID().toString(),
            no = counter++,
            message = request.message
        )
        println(message.asJson())
        val sendResult: SendResult<String> = template.send("sample-object-queue", message.asJson())
        println("Object message sent: $sendResult")
    }

    class Request(
        val message: String
    )
}