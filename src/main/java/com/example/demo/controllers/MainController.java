package com.example.demo.controllers;

import com.example.demo.entities.Project;
import com.example.demo.entities.Task;
import com.example.demo.services.implementations.ProjectServiceImpl;
import com.example.demo.services.implementations.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ProjectServiceImpl projectService;

    @Autowired
    private TaskServiceImpl taskService;

    //CRUD methods for Project entity check using postman
    @GetMapping
    public List<Project> allProjects(Model model){
        return projectService.view();
    }

    //order project by start date
    @GetMapping(value="/sort")
    public List<Project> allProjectsSort()
    {
        return projectService.sortByStart();
    }

    //Adding new project
    @PostMapping(value = "/project")
    public String addProject(@RequestBody Project project){
        projectService.create(project);
        return "project added";
    }

    //Deleting project
    @DeleteMapping(value="/project/{id}")
    public String deleteProject(@PathVariable Long id){
        projectService.delete(id);
        return "project deleted";
    }




    //CRUD methods for Task entity check using postman
    @GetMapping("/allTasks")
    public List<Task> allTasks(){
        return taskService.view();
    }

    //Adding task
    @PostMapping(value = "/task")
    public String addTask(@RequestBody Task task){
        taskService.create(task);
        return "task added";
    }

    //Adding existing task to existing Project
    @PostMapping(value = "/task/{taskId}/{projectId}")
    public String addTaskToProject(@PathVariable Long taskId,@PathVariable(name="projectId")Long  projectId){
        Project project=projectService.getById(projectId);
        Task task=taskService.getTaskById(taskId);
        task.setProject(project);
        taskService.create(task);
        return "task added to project";
    }

    //Delete task using id of task
    @DeleteMapping(value="/task/{id}")
    public String deleteTask(@PathVariable Long id){
        taskService.delete(id);
        return "task deleted";
    }

    //Deleting task from project
    @DeleteMapping(value="/task/{taskId}/{projectId}")
    public String deleteTaskFromProject(@PathVariable Long taskId,@PathVariable Long projectId){
        Task task=taskService.getTaskById(taskId);
        task.setProject(null);
        taskService.save(task);
        return "task deleted from project";
    }

    //View tasks of project
    @GetMapping("/allTasks/{projectId}")

    public List<Task> allTasks(@PathVariable Long projectId){
        return taskService.getTasksByProjectId(projectId);
    }







}
