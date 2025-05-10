package com.example.ko_app.Task;

public class TaskResponse {

    private String taskTitle;
    private String taskDescription;
    private String taskDate;
    private String taskNote;
    private String taskStatus;

    public TaskResponse(){}

    public TaskResponse(String taskTitle, String taskDescription, String taskDate, String taskNote, String taskStatus) {
        this.taskTitle = taskTitle;
        this.taskDescription = taskDescription;
        this.taskDate = taskDate;
        this.taskNote = taskNote;
        this.taskStatus = taskStatus;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(String taskDate) {
        this.taskDate = taskDate;
    }

    public String getTaskNote() {
        return taskNote;
    }

    public void setTaskNote(String taskNote) {
        this.taskNote = taskNote;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "TaskResponse{" +
                "taskTitle='" + taskTitle + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", taskDate='" + taskDate + '\'' +
                ", taskNote='" + taskNote + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                '}';
    }
}
