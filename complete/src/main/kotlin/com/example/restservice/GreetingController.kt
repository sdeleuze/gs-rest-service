package com.example.restservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    companion object {
        private val template: String = "Hello, %s!"
    }
    private val counter = AtomicLong()

    @GetMapping("/greeting")
    fun greeting(@RequestParam name: String = "World"): Greeting {
        return Greeting(counter.incrementAndGet(), String.format(template, name))
    }
}