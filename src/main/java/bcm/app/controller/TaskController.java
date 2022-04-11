package bcm.app.controller;


import bcm.app.model.agent.Task;
import bcm.app.repository.agent.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public Iterable<Task> getAll() {//получить все записи
        return taskRepository.findAll();
    }

}
