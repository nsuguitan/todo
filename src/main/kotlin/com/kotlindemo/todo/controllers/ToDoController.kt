package com.kotlindemo.todo.controllers

import com.kotlindemo.todo.entities.Todo
import com.kotlindemo.todo.entities.TodoRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/todos")
class ToDoController(val todoRepository: TodoRepository) {

    @PostMapping
    fun newToDo(@RequestBody todo: Todo): Todo{
        return todoRepository.save(todo)
    }
}