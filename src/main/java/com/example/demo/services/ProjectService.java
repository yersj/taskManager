package com.example.demo.services;

import com.example.demo.entities.Project;

import java.util.List;

public interface ProjectService {
     Project getById(Long id);
     void create(Project project);
     List<Project> view();
     void edit(Project project);
     void delete(Long id);
     List<Project> findByOrderByStartAsc();

}
