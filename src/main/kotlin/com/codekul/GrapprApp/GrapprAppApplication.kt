package com.codekul.GrapprApp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class GrapprAppApplication

fun main(args: Array<String>) {
    SpringApplication.run(GrapprAppApplication::class.java, *args)
}
