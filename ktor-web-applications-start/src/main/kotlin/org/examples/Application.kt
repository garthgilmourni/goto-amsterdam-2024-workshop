package org.examples

import io.ktor.server.application.*
import org.examples.plugins.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    configureTemplating()
    configureRouting()
}
