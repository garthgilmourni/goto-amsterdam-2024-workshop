package org.exercises

import io.ktor.server.application.*
import org.exercises.db.FakeTaskRepository
import org.exercises.db.PostgresTaskRepository
import org.exercises.model.Priority.Low
import org.exercises.model.Priority.Medium
import org.exercises.model.Task
import org.exercises.plugins.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val repository = PostgresTaskRepository()
    configureSerialization(repository)
    configureDatabases()
    configureRouting()
}

fun Application.testModule() {
    val tasks = mutableListOf(
        Task("cleaning", "Clean the house", Low),
        Task("gardening", "Mow the lawn", Medium),
        Task("painting", "Paint the fence", Medium),
        Task("climbing", "Go climb a rock", Medium)
    )
    val repository = FakeTaskRepository(tasks)
    configureSerialization(repository)
    configureRouting()
}