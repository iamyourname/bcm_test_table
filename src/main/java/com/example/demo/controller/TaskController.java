package com.example.demo.controller;


import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired

    private TaskRepository taskRepository;



    @PostMapping("/tasks")

    public Task create(@RequestBody Task task) {

        return taskRepository.save(task);

    }


}
