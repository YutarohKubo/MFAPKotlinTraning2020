package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import spark.Spark.*

fun main() {
    val objectMapper = ObjectMapper().registerKotlinModule()
    val jsonTransformer = JsonTransformer(objectMapper)
    val taskRepository = TaskRepository()
    val taskController = TaskController(objectMapper, taskRepository)

    path("/tasks") {
        get("", taskController.index(), jsonTransformer)
        get("/:id", taskController.show(), jsonTransformer)
        post("", taskController.create(), jsonTransformer)
        delete("/:id", taskController.destroy(), jsonTransformer)
    }
}
