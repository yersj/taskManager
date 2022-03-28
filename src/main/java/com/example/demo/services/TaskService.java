package com.example.demo.services;

import com.example.demo.entities.Project;
import com.example.demo.entities.Task;

import java.util.List;

public interface TaskService {
    void create(Task task);
    List<Task> view();
    void edit(Task task);
    void delete(Long id);
    void save(Task task);
    Task getTaskById(Long id);
    void deleteTaskByProjectId(Long task_id,Long project_id);
    List<Task> getTasksByProjectId(Long project_id);


}
