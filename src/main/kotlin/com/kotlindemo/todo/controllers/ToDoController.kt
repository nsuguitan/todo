package com.kotlindemo.todo.controllers

import com.kotlindemo.todo.entities.Todo
import com.kotlindemo.todo.entities.TodoRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.web.bind.annotation.*
import java.util.Optional


@RestController
@RequestMapping("/todos")
class ToDoController(val todoRepository: TodoRepository) {

    @GetMapping
    fun getTodos() = todoRepository.findAll()

    @GetMapping("/{todoId}")
    fun getTodo(@PathVariable("todoId") todoId: Long): Optional<Todo> {
        return todoRepository.findById(todoId)
    }

    @PostMapping
    fun newTodo(@RequestBody todo: Todo): Todo{
        return todoRepository.save(todo)
    }

    @PutMapping("/{todoId}")
    fun updateTodo(@PathVariable("todoId") todoId: Long, @RequestBody updatedTodo: Todo): Todo? {
        val oldTodo = todoRepository.findByIdOrNull(todoId)
        if(oldTodo == null){
            return oldTodo
        }

        return todoRepository.save(updatedTodo)
    }

    @DeleteMapping("/{todoId}")
    fun deleteTodo(@PathVariable("todoId") todoId: Long){
        todoRepository.deleteById(todoId)
    }
}