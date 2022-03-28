package com.example.demo.services.implementations;

import com.example.demo.entities.Task;
import com.example.demo.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl {
        @Autowired
        private TaskRepository taskRepository;

        public void create(Task task){
                taskRepository.save(task);
        }
    public void save(Task task){
        taskRepository.save(task);
    }
        public List<Task> view(){
                return taskRepository.findAll();
        }
//        void edit(Task task);
        public void delete(Long id){
                taskRepository.deleteById(id);
        }

      public Task getTaskById(Long id){
                return taskRepository.getById(id);
      }
       public List<Task> getTasksByProjectId(Long project_id){
                return taskRepository.findAllByProjectId(project_id);
        }


}
