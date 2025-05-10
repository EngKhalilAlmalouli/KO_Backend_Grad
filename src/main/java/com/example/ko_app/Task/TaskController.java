package com.example.ko_app.Task;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Review.ReviewRequest;
import com.example.ko_app.Review.ReviewResponse;
import com.example.ko_app.Review.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    // Constructor for dependency injection

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<?>> getAllTaskss() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @GetMapping("/{id}")
    public TaskResponse getTaskById(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest request) {
        return taskService.createTask(request);
    }

    @PutMapping("/{id}")
    public TaskResponse updateTask(@PathVariable Integer id, @RequestBody TaskRequest request) {
        return taskService.updateTask(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Integer id) throws NotFoundInDatabaseException {
        return taskService.deleteTask(id);
    }
}
