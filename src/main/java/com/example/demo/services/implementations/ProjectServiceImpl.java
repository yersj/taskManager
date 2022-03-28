package com.example.demo.services.implementations;

import com.example.demo.entities.Project;
import com.example.demo.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl {
    @Autowired
    private ProjectRepository projectRepository;

    //create
    public void create(Project project){
        projectRepository.save(project);
    }

    //view
    public List<Project> view(){
        return projectRepository.findAll();
    }

    //
    public void edit(Project project){
        projectRepository.save(project);
    }

    public void delete(Long id){
        projectRepository.deleteById(id);
    }

    public Project getById(Long id){
        return projectRepository.getById(id);
    }

    public List<Project> sortByStart(){
        return projectRepository.findByOrderByStartAsc();
    }
}
