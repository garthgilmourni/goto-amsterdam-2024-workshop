package org.exercises.db

import org.exercises.model.Priority
import org.exercises.model.Task
import org.exercises.model.TaskRepository

class FakeTaskRepository(private val tasks: MutableList<Task>) : TaskRepository {
    override suspend fun allTasks(): List<Task> = tasks

    override suspend fun tasksByPriority(priority: Priority) = tasks.filter {
        it.priority == priority
    }

    override suspend fun taskByName(name: String) = tasks.find {
        it.name.equals(name, ignoreCase = true)
    }

    override suspend fun addTask(task: Task) {
        if (taskByName(task.name) != null) {
            throw IllegalStateException("Cannot duplicate task names!")
        }
        tasks.add(task)
    }

    override suspend fun removeTask(name: String): Boolean {
        return tasks.removeIf { it.name == name }
    }
}