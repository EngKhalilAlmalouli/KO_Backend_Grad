package com.example.ko_app.Task;

import com.example.ko_app.Configruration.NotFoundInDatabaseException;
import com.example.ko_app.Review.Review;
import com.example.ko_app.Review.ReviewRepository;
import com.example.ko_app.Review.ReviewRequest;
import com.example.ko_app.Review.ReviewResponse;
import com.example.ko_app.validation.ObjectValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final ObjectValidator<TaskRequest> validator;

    // Constructor for dependency injection
    public TaskService(TaskRepository taskRepository, ObjectValidator<TaskRequest> validator) {
        this.taskRepository = taskRepository;
        this.validator = validator;
    }

    public List<?> getAllTask() {
        return taskRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    // getTaskByID
    public TaskResponse getTaskById(Integer id) {
        return taskRepository.findById(id)
                .map(this::mapToResponse)
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    // createTask
    public TaskResponse createTask(TaskRequest request) {
        validator.validate(request);
        Task task = new Task();
        task.setTitle(request.getTaskTitle());
        task.setDescription(request.getTaskDescription());
        task.setNote(request.getTaskNote());
        task.setDate(request.getTaskDate());
        task.setStatus(request.getTaskStatus());
        taskRepository.save(task);
        return mapToResponse(task);
    }

    // updateTask
    public TaskResponse updateTask(Integer id, TaskRequest request) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        validator.validate(request);

        task.setTitle(request.getTaskTitle());
        task.setDescription(request.getTaskDescription());
        task.setNote(request.getTaskNote());
        task.setDate(request.getTaskDate());
        task.setStatus(request.getTaskStatus());
        task = taskRepository.save(task);
        return mapToResponse(task);
    }

    // deleteTask
    public ResponseEntity<?> deleteTask(Integer id) throws NotFoundInDatabaseException {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundInDatabaseException("Task not found"));

        taskRepository.delete(task); // Ensure the customer is actually deleted
        return ResponseEntity.status(HttpStatus.OK).body("Task deleted successfully");
    }

    // mapToResponse
    private TaskResponse mapToResponse(Task task) {
        List<Integer> taskIds = new ArrayList<>();
        TaskResponse response = new TaskResponse();
        response.setTaskTitle(task.getTitle());
        response.setTaskDescription(task.getDescription());
        response.setTaskNote(task.getNote());
        response.setTaskStatus(task.getStatus());
        response.setTaskDate(task.getDate());
        return response;
    }
}
