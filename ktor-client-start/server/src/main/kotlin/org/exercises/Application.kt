package org.exercises

import SERVER_PORT
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.exercises.model.FakeTaskRepository

import org.exercises.model.Task
import org.exercises.model.Priority.*
import org.exercises.plugins.configureRouting
import org.exercises.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    val tasks = mutableListOf(
        Task("cleaning", "Clean the house", Low),
        Task("gardening", "Mow the lawn", Medium),
        Task("shopping", "Buy the groceries", High),
        Task("painting", "Paint the fence", Medium)
    )
    val repository = FakeTaskRepository(tasks)

    configureSerialization(repository)
    configureRouting()
}