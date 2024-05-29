package org.exercises.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.exercises.model.TaskRepository
import org.exercises.view.tasksAsTable

fun Application.configureRouting() {
    routing {
        staticResources("/tasks-ui", "tasks-ui")
        route("/tasks") {
            get {
                val tasks = TaskRepository.allTasks()
                call.respondText(
                    contentType = ContentType.parse("text/html"),
                    text = tasks.tasksAsTable()
                )
            }
            get("/byName/{taskName}") {
                val name = call.parameters["taskName"]
                if (name == null) {
                    call.respond(HttpStatusCode.BadRequest)
                    return@get
                }
                val task = TaskRepository.taskByName(name)
                if (task == null) {
                    call.respond(HttpStatusCode.NotFound)
                    return@get
                }
                call.respondText(
                    contentType = ContentType.parse("text/html"),
                    text = listOf(task).tasksAsTable()
                )
            }
        }
    }
}
