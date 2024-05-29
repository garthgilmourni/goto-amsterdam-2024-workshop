package org.exercises

import io.ktor.server.application.*
import org.exercises.model.FakeTaskRepository
import org.exercises.model.Priority
import org.exercises.model.Priority.*
import org.exercises.model.Task
import org.exercises.plugins.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
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

fun Application.testModule() {
    val tasks = mutableListOf(
        Task("cleaning", "Clean the house", Priority.Low),
        Task("gardening", "Mow the lawn", Priority.Medium),
        Task("painting", "Paint the fence", Priority.Medium),
        Task("climbing", "Go climb a rock", Priority.Medium)
    )
    val repository = FakeTaskRepository(tasks)
    configureSerialization(repository)
}