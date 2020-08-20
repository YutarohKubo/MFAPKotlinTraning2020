package todolist

import com.fasterxml.jackson.databind.ObjectMapper
import spark.Request
import spark.Route
import spark.Spark.halt
import java.nio.charset.Charset

class TaskController(private val objectMapper: ObjectMapper, private val taskRepository: TaskRepository) {

    private val Request.task: Task?
        get() {
            val id = params("id").toLongOrNull()
            //return id?.run { taskRepository.findById(this) }
            return id?.let(taskRepository::findById)
        }

    fun index(): Route = Route { request, response ->
        taskRepository.findAll()
    }

    fun create(): Route = Route {req, res ->
        //println(String(req.body().toByteArray(Charset.forName("SHIFT-JIS"))))
        val request: TaskCreateRequest =
            objectMapper.readValue(req.bodyAsBytes()) ?: run {
                println("huhuhu")
                throw halt(400)
            }
        val task = taskRepository.create(request.content)
        res.status(201)
        task
    }

    fun show(): Route = Route {req, res ->
        req.task ?: throw halt(404)
    }

    fun destroy(): Route = Route { request, response ->
        val task = request.task ?: throw halt(404)
        taskRepository.delete(task)
        response.status(204)
    }

}