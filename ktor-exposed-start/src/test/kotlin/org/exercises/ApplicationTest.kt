package org.exercises

import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.config.*
import io.ktor.server.testing.*
import org.exercises.model.Priority.*
import org.exercises.model.Task
import org.exercises.plugins.configureRouting
import org.exercises.plugins.configureSerialization
import org.junit.Test
import kotlin.test.*

class ApplicationTest {
    @Test
    fun fourTasksCanBeFound() = testApplication {
        environment {
            config = ApplicationConfig("test-application.yaml")
        }

        val client = restClient()

        val response = client.get("/tasks")
        val results = response.body<List<Task>>()

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals(4, results.size)
    }

    @Test
    fun tasksCanBeFoundByPriority() = testApplication {
        environment {
            config = ApplicationConfig("test-application.yaml")
        }

        val client = restClient()

        val response = client.get("/tasks/byPriority/Medium")
        val results = response.body<List<Task>>()

        assertEquals(HttpStatusCode.OK, response.status)

        val expectedTaskNames = listOf("gardening", "painting", "climbing")
        val actualTaskNames = results.map(Task::name)
        assertContentEquals(expectedTaskNames, actualTaskNames)
    }

    @Test
    fun invalidPriorityProduces400() = testApplication {
        environment {
            config = ApplicationConfig("test-application.yaml")
        }

        val response = client.get("/tasks/byPriority/Invalid")
        assertEquals(HttpStatusCode.BadRequest, response.status)
    }

    @Test
    fun unusedPriorityProduces404() = testApplication {
        environment {
            config = ApplicationConfig("test-application.yaml")
        }

        val response = client.get("/tasks/byPriority/High")
        assertEquals(HttpStatusCode.NotFound, response.status)
    }

    @Test
    fun newTasksCanBeAdded() = testApplication {
        environment {
            config = ApplicationConfig("test-application.yaml")
        }

        val client = restClient()

        val task = Task("swimming", "Go to the beach", Low)
        val response1 = client.post("/tasks") {
            header(
                HttpHeaders.ContentType,
                ContentType.Application.Json
            )

            setBody(task)
        }
        assertEquals(HttpStatusCode.NoContent, response1.status)

        val response2 = client.get("/tasks")
        assertEquals(HttpStatusCode.OK, response2.status)

        val taskNames = response2
            .body<List<Task>>()
            .map { it.name }

        assertContains(taskNames, "swimming")
    }

    private fun ApplicationTestBuilder.restClient() = createClient {
        install(ContentNegotiation) {
            json()
        }
    }
}
